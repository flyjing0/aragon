/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: DJLTest
 * Author:   Administrator
 * Date:     2022/11/30 15:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aragon.djl.test;

import ai.djl.MalformedModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.transform.Normalize;
import ai.djl.modality.cv.transform.Resize;
import ai.djl.modality.cv.transform.ToTensor;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.index.NDIndex;
import ai.djl.ndarray.types.DataType;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.translate.TranslateException;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2022/11/30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/djl")
public class DJLTest {

    private Logger logger = LoggerFactory.getLogger(DJLTest.class);

    @PostMapping("test")
    public String test() throws ModelNotFoundException, MalformedModelException, IOException, TranslateException {
        logger.info("************************* 初始化translator开始 *************************");
        Translator<String/*filename*/, String/*class*/> translator = new Translator<String, String>() {
            @Override
            public NDList processInput(TranslatorContext ctx, String input) throws Exception {
                // 根据路径读取图片
                Image image = ImageFactory.getInstance().fromFile(Paths.get(input));
                NDArray ndArray = image.toNDArray(ctx.getNDManager());
                // 在图片送入resnet前要做一些预处理，官方的例子中使用transforms，但为了本文的前后呼应，我这里就用上面将的NDArray的操作来完成
                Resize resize = new Resize(256, 256);
                // 将图片的大小resize到256x256
                ndArray = resize.transform(ndArray);
                // py: transforms.CenterCrop(224)
                // NDArray没有CenterCrop方法，但是我们可以通过切片的方式实现
                ndArray = ndArray.get(new NDIndex("16:240, 16:240, :"));
                // ToTensor会将Shape的(224,224,3)转变为(3,224,224)，并且将值从0-255缩放到0-1
                ndArray = new ToTensor().transform(ndArray);
                // py: transforms.Normalize(mean=[0.485, 0.456, 0.406], std=[0.229, 0.224, 0.225])
                Normalize normalize = new Normalize(new float[]{0.485f, 0.456f, 0.406f}, new float[]{0.229f, 0.224f, 0.225f});
                ndArray = normalize.transform(ndArray);
                // resnet只接受一个Tensor
                return new NDList(ndArray);
            }

            @Override
            public String processOutput(TranslatorContext ctx, NDList list) throws Exception {
                // resnet只返回一个tensor，所以要get(0)
                int index = list.get(0).argMax().toType(DataType.INT32, false).getInt();
                // 由于resnet可以识别1000种物体，这里我就只给index了。
                return index + "";
            }
        };
        logger.info("************************* 初始化translator结束 *************************");
        logger.info("************************* translator：" + JSON.toJSONString(translator));
        Criteria<String, String> criteria = Criteria.builder()
                .setTypes(String.class, String.class)
                .optModelPath(Paths.get("model/resnet18-5c106cde.pth"))
                .optOption("mapLocation", "true")
                .optTranslator(translator)
                .build();

        ZooModel model = criteria.loadModel();
        Predictor predictor = model.newPredictor();
        String result = JSON.toJSONString(predictor.predict("picture/test.png"));
        return result;
    }


}
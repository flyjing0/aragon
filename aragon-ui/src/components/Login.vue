<template>
<el-form>
  <el-row>
    <el-col :span="8">
      <div class="grid-content bg-purple">
          用户名：<el-input v-model="username" placeholder="请输入用户名" size="medium"></el-input>
      </div>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="8">
      <div class="grid-content bg-purple">
        密  码：  <el-input v-model="password" placeholder="请输入密码" :show-password="true"></el-input>
      </div>
    </el-col>
  </el-row>
  <el-button type="submit">提交</el-button>
</el-form>
</template>

<script>
export default {
  name: "LoginViews",
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: [

  ]
}
</script>

<style scoped>

</style>
import Vue from 'vue'
import VueI18n from 'vue-i18n'
import Cookies from 'js-cookie'
import elementZhLocale from 'element-ui/lib/locale/lang/zh-CN'// element-ui lang
import zhLocale from './zh'

Vue.use(VueI18n)

const messages = {
  zh: {
    ...zhLocale,
    ...elementZhLocale
  }
}
export function getLanguage() {
  const chooseLanguage = Cookies.get('language')
  console.log('chooseLanguage: ' + chooseLanguage)
  if (chooseLanguage) return chooseLanguage

  // if has not choose language
  const language = (navigator.language || navigator.browserLanguage).toLowerCase()
  console.log('language: ' + language)
  const locales = Object.keys(messages)
  console.log('locales: ' + locales)
  for (const locale of locales) {
    if (language.indexOf(locale) > -1) {
      console.log('language.indexOf(locale): ' + language.indexOf(locale))
      return locale
    }
  }
  return 'zh'
}
const i18n = new VueI18n({
  // set locale
  // options: en | zh | es
  locale: getLanguage(),
  // set locale messages
  messages
})

export default i18n

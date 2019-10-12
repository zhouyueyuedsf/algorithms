package lang

import common.Item
import common.Lang
import common.LangToLang

class LangProvider {
    companion object {
        private val sLangCrossList = createIntern()
        private var sLangs: ArrayList<Item>? = null
            get() {
                if (field == null) {
                    field = sLangCrossList.chooseRowListByColor(0)
                }
                return field
            }
        /**
         * id直接作为数组索引
         */
        fun getLangInstant(lang: Lang): Lang? {
            val id = lang.id
            var resLang: Lang? = null
            if (id != null) {
                return getLangById(id)
            } else if (lang.abbr != null) {

            }

            return resLang
        }

        fun getLangById(id: Int): Lang? {
            return sLangs?.get(id) as Lang
        }

        private fun createIntern(): LangCrossList {
            val arrList = arrayListOf<ArrayList<LangToLang>>()
            for (i in 0 until 1) {
                val item1 = Lang(i, "en")
                val item2 = Lang(i + 6, "zh")
                val item3 = Lang(i + 7, "us")
                val list = arrayListOf<LangToLang>()
                list.add(LangToLang(item1, item2))
                list.add(LangToLang(item2, item1))
                list.add(LangToLang(item1, item3))
                list.add(LangToLang(item3, item1))
                list.add(LangToLang(item2, item3))
                list.add(LangToLang(item3, item2))
                arrList.add(list)
            }
            val crossList = LangCrossList(arrList, 1)

            val arrList2 = arrayListOf<ArrayList<LangToLang>>()

            for (i in 0 until 1) {
                val item1 = Lang(i, "en")
                val item2 = Lang(i + 6, "zh")
                val item3 = Lang(i + 7, "us")
                val list = arrayListOf<LangToLang>()
                list.add(LangToLang(item1, item3))
                list.add(LangToLang(item3, item1))
                arrList2.add(list)
            }
            crossList.createOrUpdate(arrList2, 2)
            return crossList
        }
    }
}
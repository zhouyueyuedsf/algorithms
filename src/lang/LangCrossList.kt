package lang
import common.*

class LangCrossList(origin: List<List<LangToLang>>?,
                    sceneColor: Int) : CrossList<LangToLang>(origin, sceneColor) {

    constructor(headRowItems: List<Item>, headColItems: List<Item>): this(null, 0) {
        for (lang in headRowItems) {
            val headNode = Node(lang.id, null, 0, lang)
            rowHeadNodeMap[lang.id!!] = headNode
        }
        for (lang in headColItems) {
            val headNode = Node(null, lang.id, 0, lang)
            colHeadNodeMap[lang.id!!] = headNode
        }
    }

    fun addOrUpdateAll(origin: List<List<LangToLang>>, sceneColor: Int) {
        createOrUpdate(origin, sceneColor)
    }
    fun getIndexHashMap(): HashMap<String, Int> {
        val hashMap = HashMap<String, Int>()
        for (entry in rowHeadNodeMap) {
            hashMap[(entry.value.item as Lang).abbr!!] = entry.value.rowId!!
        }
        return hashMap
    }

//    fun getSupportIdListByFrom(from: Lang): List<Item> {
//        var head = rowHeadNodeMap[from.id!!]
//        val items = arrayListOf<Lang>()
//        while (head != null) {
//            items.add(Item(head.rowId))
//            head = head.rowNext
//        }
//        return items
//    }

    fun getRecentUsedLang(num: Int, color: Int? = 0): List<Lang> {
        val iterator = ArrayList<Map.Entry<Int, Node>>(rowHeadNodeMap.entries)
                .listIterator(rowHeadNodeMap.size)
        //
        var count = 0
        val list = arrayListOf<Lang>()
        while (iterator.hasPrevious() && count < count) {
            val entry = iterator.previous()
            list.add(entry.value.item as Lang)
            count++
        }
        return list
    }
}
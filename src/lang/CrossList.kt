package common


/**
 * 十字链表节点构造
 */
class Node(
        var rowId: Int? = 0,
        var colId: Int? = 0,
        var color: Int = 0,
        var item: Item ?= null,
        var rowNext: Node? = null,
        var colNext: Node? = null
)

open class Item(
        var id: Int?
)

open class ItemEdge(
        var startItem: Item,
        var endItem: Item
)
class CommonLanguage(id: Int? = null,
                     val englishName: String? = null,
                     val localName: String? = null,
                     val abbr: String? = null,
                     val ietf: String? = null) : Item(id) {

    override fun toString(): String {
        return "id = $id, englishName = $englishName, localName$localName, abbr = $abbr"
    }
}
class LangToLang(from: CommonLanguage, to: CommonLanguage): ItemEdge(from, to) {

}
/**
 * origin： 数据类型要求如下 [[A->B,A->C],[B->C,B->D]]
 */
open class CrossList<out T: ItemEdge>(origin: List<List<T>>?, sceneColor: Int) {
    val rowHeadNodeMap = LinkedHashMap<Int, Node>()
    val colHeadNodeMap = LinkedHashMap<Int, Node>()
    init {
        if (origin != null) {
            createOrUpdate(origin, sceneColor)
        }
//        val colNodeSetMap = hashMapOf<Int, HashSet<Node>>()
////        按行遍历，确定rowHeadNodeMap
//        for (itemEdgeArr in origin) {
//            val rowHeadNode = Node()
//            var curHeadNode = rowHeadNode
//            var arrId = 0
//            for (itemEdge in itemEdgeArr) {
//                val rowId = itemEdge.startItem.id
//                val colId = itemEdge.endItem.id
//                val color = sceneColor
//                val node = Node(rowId, colId, color)
//                curHeadNode.rowId = rowId
//                curHeadNode.rowNext = node
//                curHeadNode = node
//                arrId = rowId
//
//                if (colNodeSetMap.containsKey(colId)) {
//                    val set = colNodeSetMap[colId]
//                    set?.add(node)
//                } else {
//                    val set = hashSetOf<Node>()
//                    set.add(node)
//                    colNodeSetMap[colId] = set
//                }
//            }
//            rowHeadNodeMap[arrId] = rowHeadNode
//        }
////        遍历列
//        for (colNodeSetEntry in colNodeSetMap) {
//            val set = colNodeSetEntry.value
//            val colHeadNode = Node()
//            var curHeadNode = colHeadNode
//            var arrId = 0
//            for (node in set) {
//                curHeadNode.colId = node.colId
//                curHeadNode.colNext = node
//                curHeadNode = node
//                arrId = curHeadNode.colId
//            }
//            colHeadNodeMap[arrId] = colHeadNode
//        }
    }
    open fun onPreCreate(){}
    fun createOrUpdate(origin: List<List<ItemEdge>>, sceneColor: Int) {
        for (itemEdgeArr in origin) {
            for (itemEdge in itemEdgeArr) {
//                val rowId = itemEdge.startItem.id
//                val colId = itemEdge.endItem.id
//                val color = sceneColor
                addOrUpdate(itemEdge, sceneColor)
            }
        }
    }
    private fun addOrUpdate(edge: ItemEdge, sceneColor: Int) {
        val rowId = edge.startItem.id
        val colId = edge.endItem.id
        if (colId == null || rowId == null) {
            return
        }
        var headNode = rowHeadNodeMap[rowId]
        var curNode = headNode
//        给行头结点上色
        if (headNode != null) {
            headNode.color = headNode.color.or(sceneColor)
        }
        while (curNode != null) {
            if (curNode.colId == colId) {
                if (!hasColor(curNode.color, sceneColor)) {
                    curNode.color = curNode.color.or(sceneColor)
                }
//                列头结点上色
                headNode = colHeadNodeMap[colId]
                if (headNode != null && !hasColor(headNode.color, sceneColor)) {
                    headNode.color = headNode.color.or(sceneColor)
                }
                return
            }
            curNode = curNode.rowNext
        }
        addNode(edge.startItem, edge.endItem, sceneColor)
    }

    private fun addNode(start: Item, end: Item, color: Int) {
        val rowId = start.id!!
        val colId = end.id!!
        var headNode = rowHeadNodeMap[rowId]
        val node = Node(rowId, colId, color)
        // 处理行指针
        if (headNode == null) {
            headNode = Node(rowId, null, color, start)
            rowHeadNodeMap[rowId] = headNode
        }
        var nextNode = headNode.rowNext
        node.rowNext = nextNode
        headNode.rowNext = node
        // 处理列指针
        headNode = colHeadNodeMap[colId]
        if (headNode == null) {
            headNode = Node(null, colId, color, end)
            colHeadNodeMap[colId] = headNode
        }
        nextNode = headNode.colNext
        node.colNext = nextNode
        headNode.colNext = node
    }

    open fun hasColor(mainColor: Int, color: Int) = mainColor.and(color) == color
    /**
     * 得到出度
     */
    fun getOutItemsById(id: Int, color: Int): List<Item> {
        var head = rowHeadNodeMap[id]
        val items = arrayListOf<Item>()
        while (head != null) {
            if (head.colId != null && hasColor(head.color, color)) {
                items.add(Item(head.colId))
            }
            head = head.rowNext
        }
        return items
    }

    fun getInItemsById(id: Int, color: Int): List<Item> {
        var head = colHeadNodeMap[id]
        val items = arrayListOf<Item>()
        while (head != null) {
            if (head.rowId != null && hasColor(head.color, color)) {
                items.add(Item(head.rowId))
            }
            head = head.colNext
        }
        return items
    }

    fun chooseRowListByColor(maskColor: Int) = run {
        val list = arrayListOf<Item>()
        for (entry in rowHeadNodeMap) {
            if (entry.value.item != null && entry.value.color.and(maskColor) == maskColor) {
                list.add(entry.value.item!!)
            }
        }
        list
    }
    fun chooseColListByColor(maskColor: Int) = run {
        val list = arrayListOf<Item?>()
        for (entry in colHeadNodeMap) {
            if (entry.value.item != null && entry.value.color.and(maskColor) == maskColor) {
                list.add(entry.value.item)
            }
        }
        list
    }
}
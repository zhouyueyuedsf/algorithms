package common


/**
 * 十字链表节点构造
 */
data class Node(
        var rowId: Int = 0,
        var colId: Int = 0,
        var color: Int = 0,
        var rowNext: Node? = null,
        var colNext: Node? = null
)


class Item(
        var id: Int
)

data class ItemEdge(
        var startItem: Item,
        var endItem: Item
)

/**
 * orgin： 数据类型要求如下 [[A->B,A->C],[B->C,B->D]]
 */
class CrossList(var orgin: List<List<ItemEdge>>, var sceneColor: Int) {
    private val rowHeadNodeMap = hashMapOf<Int, Node>()
    private val colHeadNodeMap = hashMapOf<Int, Node>()

    init {
        val colNodeSetMap = hashMapOf<Int, Set<Node>>()
//        按行遍历，确定rowHeadNodeMap
        for (itemEdgeArr in orgin) {
            val rowHeadNode = Node()
            var curHeadNode = rowHeadNode
            var arrId = 0
            for (itemEdge in itemEdgeArr) {
                val rowId = itemEdge.startItem.id
                val colId = itemEdge.endItem.id
                val color = sceneColor
                val node = Node(rowId, colId, color)
                curHeadNode.rowNext = node
                curHeadNode = node
                arrId = rowId

                val set = colNodeSetMap.getOrDefault(colId, setOf())
                set.plus(node)
                colNodeSetMap[colId] = set
            }
            rowHeadNodeMap[arrId] = rowHeadNode
        }
//        遍历列
        for (colNodeSetEntry in colNodeSetMap) {
            val set = colNodeSetEntry.value
            val colHeadNode = Node()
            var curHeadNode = colHeadNode
            var arrId = 0
            for (node in set) {
                curHeadNode.colNext = node
                curHeadNode = node
                arrId = curHeadNode.colId
            }
            colHeadNodeMap[arrId] = colHeadNode
        }
    }

    /**
     * 得到出度
     */
    fun getOutItemsById(id: Int): List<Item> {
        var head = rowHeadNodeMap[id]
        val items = arrayListOf<Item>()
        while (head != null) {
            items.add(Item(head.rowId))
            head = head.rowNext
        }
        return items
    }

    fun getInItemsById(id: Int): List<Item> {
        var head = colHeadNodeMap[id]
        val items = arrayListOf<Item>()
        while (head != null) {
            items.add(Item(head.colId))
            head = head.colNext
        }
        return items
    }
}

fun main() {
    val arrList = arrayListOf<ArrayList<ItemEdge>>()
    for (i in 0 .. 6) {
        val item1 = Item(i)
        val item2 = Item(i + 6)
        val item3 = Item(i + 7)
        val list = arrayListOf<ItemEdge>()
        list.add(ItemEdge(item1, item2))
        list.add(ItemEdge(item1, item3))
        arrList.add(list)
    }
    val crossList = CrossList(arrList, 1)

//    arrList[2][2]
    val res = crossList.getInItemsById(6)
    print(res)
}
package offline

/**
 * 属性和字段的区别
 */
class Node(var id: Int = 0,
           var parent: Node? = null) {
    var status: Int = 0
        set(value) {
            var node: Node? = this
            if (node!!.parent != null) {
                node.parent!!.status = 2
            }
            field = value
        }
}

fun main() {
    val node1 = Node(1)
    val node2 = Node(2, node1)
    node2.status = 1

    println("node1 status: ${node1.status}, node2 status: ${node2.status}")
}
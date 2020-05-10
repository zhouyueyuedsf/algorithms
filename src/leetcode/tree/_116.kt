package leetcode.tree

import common.TreeMainClass
import common.kotlin.Node

/**
 * @time 2020/5/3
 * @author joy zhou
 */
object _116 {
    /**
     * 貌似两种类型的邻接点，可以抽象为一种类型
     */
    fun connect(root: Node?): Node? {
        if (root == null) return root
        connect(root.left)
        connect(root.right)
        var pre = root.left
        var next = root.right
        while (pre != null && next != null) {
            pre.next = next
            pre = pre.right
            next = next.left
        }
        return root
    }
}

fun main() {
    val root = _116.connect(TreeMainClass.stringToNode("[-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13]"))
    println("")
}
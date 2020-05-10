package leetcode.tree

import common.TreeMainClass
import common.kotlin.Node

/**
 * @time 2020/5/3
 * @author joy zhou
 */
object _117 {
    var prev: Node? = null
    var leftmost:Node? = null
    fun processChild(childNode: Node?) {
        if (childNode != null) {
            if (this.prev != null) {
                this.prev!!.next = childNode
            } else {
                this.leftmost = childNode
            }
            this.prev = childNode
        }
    }

    fun connect(root: Node?): Node? {
        if (root == null) {
            return root
        }
        this.leftmost = root
        var curr: Node? = leftmost
        while (this.leftmost != null) {
            this.prev = null
            curr = this.leftmost
            this.leftmost = null
            while (curr != null) {
                processChild(curr.left)
                processChild(curr.right)
                curr = curr.next
            }
        }
        return root
    }
}

fun main() {
    val root = _117.connect(TreeMainClass.stringToNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]"))
    println("")
}
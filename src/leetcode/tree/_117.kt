package leetcode.tree

import common.TreeMainClass
import common.kotlin.Node

/**
 * @time 2020/5/3
 * @author joy zhou
 */
object _117 {
    var leftMost: Node? = null
    fun connect(root: Node?): Node? {
        if (root == null) return null
        leftMost = root
        var downNode = root
        while (leftMost != null) {
            var upNode = leftMost
            while (true) {
                if (leftMost?.left != null) {
                    leftMost = leftMost?.left
                    break
                }
                if (leftMost?.right != null) {
                    leftMost = leftMost?.right
                    break
                }
                leftMost = leftMost?.next
                if (leftMost == null) break
            }
            downNode = leftMost
            while (upNode != null) {
                if (upNode.left != null && upNode.left != downNode) {
                    downNode?.next = upNode.left
                    downNode = downNode?.next
                    continue
                }
                if (upNode.right != downNode) {
                    downNode?.next = upNode.right
                    if (downNode?.next != null) {
                        downNode = downNode.next
                    }
                }
                upNode = upNode.next
            }
        }
        return root
    }
}

fun main() {
    val root = _117.connect(TreeMainClass.stringToNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]"))
    println("")
}
package leetcode.tree

import common.TreeMainClass
import common.kotlin.Node

/**
 * @time 2020/5/3
 * @author joy zhou
 */
object _117 {
    /**
     * 上下两层通过上层的next指针进行层次遍历
     *
     * 可以用该方法做log2(n)空间消耗的层次遍历
     */
    fun connect(root: Node?): Node? {
        if (root == null) return null
        var leftMost = root
        var downNode: Node?
        while (leftMost != null) {
            // 上一层的节点
            var upNode = leftMost
            // 找到下层的第一个节点
            leftMost = findFirstNode(leftMost).first
            // 下一层的节点
            downNode = leftMost
            // 根据上层节点的next填充下层节点的next
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

    /**
     * 未实现的方法
     */
    fun connect2(root: Node?): Node? {
        if (root == null) return null
        var leftMost = root
        var downNode: Node?
        while (leftMost != null) {
            // 上一层的节点
            var upNode = leftMost
            // 1.找到下层的第一个节点
            leftMost = findFirstNode(leftMost).first
            // 下一层的节点
            downNode = leftMost
            // 2. 找到downNode节点的父节点
            while (true) {
                if (upNode?.left == downNode) break
                if (upNode?.right == downNode) break
                upNode = upNode?.next
            }

            // TODO  3. 重复1的逻辑即从该upNode开始找到以downNode为起点的下层节点的第一个值
            while (upNode != null) {
                findFirstNode(upNode).apply {
                    val resNode = first
                    if (resNode != downNode) {
                        downNode?.next = resNode
                    }
                    upNode = second
                }
            }
        }
        return root
    }

    private fun findFirstNode(node: Node?): Pair<Node?, Node?> {
        var resNode = node
        var upNode = node
        while (true) {
            if (resNode?.left != null) {
                upNode = resNode
                resNode = resNode.left
                break
            }
            if (resNode?.right != null) {
                upNode = resNode
                resNode = resNode.right
                break
            }
            resNode = resNode?.next
            if (resNode == null) break
        }
        return Pair(resNode, upNode)
    }
}

fun main() {
    val root = _117.connect2(TreeMainClass.stringToNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]"))
    println("")
}
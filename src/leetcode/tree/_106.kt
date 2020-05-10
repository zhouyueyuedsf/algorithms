package leetcode.tree

import common.kotlin.TreeNode

/**
 * @time 2020/4/12
 * @author joy zhou
 */

object _106 {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return helper(inorder, postorder, postorder.lastIndex, 0, inorder.size - 1)
    }

    fun helper(inorder: IntArray, postorder: IntArray, postorderIndex: Int, inorderStart: Int, inorderEnd: Int): TreeNode? {
        // 递归退出条件判断为难点
        if (inorderStart > inorderEnd || postorderIndex < 0) return null
        val root = TreeNode(postorder[postorderIndex])
        val predicate = inorder.indexOf(root.`val`)
        // 此处preorderIndex的确定为难点, inorderEnd - predicate这个为右子节点数
        root.left = helper(inorder, postorder, postorderIndex - 1 - (inorderEnd - predicate) , inorderStart, predicate - 1)
        root.right = helper(inorder, postorder, postorderIndex - 1, predicate + 1, inorderEnd)
        return root
    }
}

fun main() {
    val root = _106.buildTree(intArrayOf(3, 2, 1), intArrayOf(3, 2, 1))
}
package leetcode.tree

import common.kotlin.TreeNode

/**
 * @time 2020/4/12
 * @author joy zhou
 */

object _105 {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return helper(preorder, inorder, 0, 0, inorder.size - 1)
    }

    fun helper(preorder: IntArray, inorder: IntArray, preorderIndex: Int, inorderStart: Int, inorderEnd: Int): TreeNode? {
        // 递归退出条件判断为难点
        if (inorderStart > inorderEnd) return null
        val root = TreeNode(preorder[preorderIndex])
        val predicate = inorder.indexOf(root.`val`)
        root.left = helper(preorder, inorder, preorderIndex + 1, inorderStart, predicate!! - 1)
        // 此处preorderIndex的确定为难点
        root.right = helper(preorder, inorder, preorderIndex + 1 + predicate - inorderStart, predicate + 1, inorderEnd)
        return root
    }

}

fun main() {
    val root = _105.buildTree(intArrayOf(1), intArrayOf(4))
}
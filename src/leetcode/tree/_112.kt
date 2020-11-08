package leetcode.tree

import common.kotlin.TreeNode

object _112 {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) return false
        return helper(root, sum)
    }

    fun helper(root: TreeNode?, sum: Int): Boolean {
        if (root != null && root.left == null && root.right == null) {
            return sum == root.`val`
        }
        if (root == null) return false
        val leftOK = helper(root.left, sum - root.`val`)
        val rightOk = helper(root.right, sum - root.`val`)
        return leftOK || rightOk
    }
}
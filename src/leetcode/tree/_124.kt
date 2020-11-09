package leetcode.tree

import common.TreeMainClass
import common.TreeNode
import kotlin.math.max

object _124 {
    var maxSum = Integer.MIN_VALUE;
    fun maxPathSum(root: TreeNode?): Int {
        helper(root)
        return maxSum
    }

    fun helper(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftSum = helper(root.left)
        val rightSum = helper(root.right)
        return max(root.`val`, max(leftSum + root.`val`, rightSum + root.`val`)).also { maxSum = max(leftSum + rightSum + root.`val`, max(maxSum, it)) }
    }

    private fun TreeNode?.isLeaf() = this != null && (left == null && right == null)
}

fun main() {
    println(_124.maxPathSum(TreeMainClass.stringToTreeNode("[-1, 2]")))
}
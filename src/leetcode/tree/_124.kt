package leetcode.tree

import common.TreeMainClass
import common.TreeNode
import kotlin.math.max

object _124 {
    var maxSum = Integer.MIN_VALUE;
    fun maxPathSum(root: TreeNode?): Int {
        helper(root, Int.MIN_VALUE, false)
        return maxSum
    }

    fun helper(root: TreeNode?, sum: Int, isLeafBefore: Boolean): Int {
        if (root == null) {
            return if (isLeafBefore) return Int.MIN_VALUE else 0
        }
        val leftSum = helper(root.left, max(sum, sum + root.`val`), root.isLeaf() || root.`val` < 0)
        val rightSum = helper(root.right, max(sum, sum + root.`val`), root.isLeaf() || root.`val` < 0)
        if (leftSum == Int.MIN_VALUE && rightSum == Int.MIN_VALUE) {
            return root.`val`.also { maxSum = max(maxSum, it) }
        }
        if (leftSum == Int.MIN_VALUE) {
            return rightSum + root.`val`.also { maxSum = max(max(rightSum, root.`val`), max(maxSum, it)) }
        }
        if (rightSum == Int.MIN_VALUE) {
            return leftSum + root.`val`.also { maxSum = max(max(leftSum, root.`val`), max(maxSum, it)) }
        }
        return max(root.`val`, max(leftSum + root.`val`, rightSum + root.`val`)).also { maxSum = max(leftSum + rightSum + root.`val`, max(maxSum, it)) }
    }

    private fun TreeNode?.isLeaf() = this != null && (left == null && right == null)
}

fun main() {
    _124.maxPathSum(TreeMainClass.stringToTreeNode("[9,-3,0,3,null,null,null,null,-8]"))
}
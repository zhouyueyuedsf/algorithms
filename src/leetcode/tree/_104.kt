package leetcode.tree

import common.TreeMainClass
import common.TreeNode

import java.lang.Integer.max

object _104 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val depthL = maxDepth(root.left)
        val depthR = maxDepth(root.right)
        // 在归的过程中处理高度
        return max(depthL, depthR) + 1
    }

    fun maxDepth2(root: TreeNode?): Int {
        return helper(root, 0)
    }

    fun helper(root: TreeNode?, depth: Int): Int {
        if (root == null) {
            println("gui if")
            return depth
        }
        // 在递的过程处理高度
        println("di left")
        val depthL = helper(root.left, depth + 1)
        println("di right")
        val depthR = helper(root.right, depth + 1)
        println("gui end")
        return max(depthL, depthR)
    }
}

fun main() {
    _104.maxDepth(TreeMainClass.stringToTreeNode("[3,9,20,null,null,15,7]"))
}
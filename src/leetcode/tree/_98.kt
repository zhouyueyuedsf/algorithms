package leetcode.tree

import common.TreeMainClass
import common.TreeNode
import java.util.*

object _98 {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        var curRoot = root
        val stack = Stack<TreeNode>()
        var max = -Double.MIN_VALUE
        while (stack.isNotEmpty() || curRoot != null) {
            while (curRoot != null) {
                stack.push(curRoot)
                curRoot = curRoot.left
            }
            // 出栈的最大值和刚出栈的值比较
            curRoot = stack.pop()
            if (curRoot.`val` <= max) {
                return false
            }
            max = curRoot.`val`.toDouble()
            curRoot = curRoot.right

        }
        return true
    }
}

fun main() {
    _98.isValidBST(TreeMainClass.stringToTreeNode("[]"))
}
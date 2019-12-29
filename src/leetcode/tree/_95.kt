package leetcode.tree

import common.TreeNode

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object _95 {
    fun generateTrees(n: Int): List<TreeNode?> {
        val arr = IntArray(n) {
            it + 1
        }
        return subGenTrees(arr)
    }

    private fun subGenTrees(subArr: IntArray): List<TreeNode> {
        if (subArr.size == 1) return arrayListOf(TreeNode(subArr[0]))
        if (subArr.size == 2) {
            val node1 = TreeNode(subArr[0])
            val node2 = TreeNode(subArr[1])
            node1.right = node2
            val newList = arrayListOf<TreeNode>()
            newList.add(node1)
            val newNode1 = TreeNode(subArr[0])
            val newNode2 = TreeNode(subArr[1])
            newNode2.left = newNode1
            newList.add(newNode2)
            return newList
        }
        val newRootList = arrayListOf<TreeNode>()
        for (index in subArr.indices) {
            var root = TreeNode(subArr[index])
            val size = subArr.size
            var rightRootList = arrayListOf<TreeNode>()
            if (index + 1 < size) {
                val nodeList = subGenTrees(subArr.copyOfRange(index + 1, size))
                nodeList.forEach {
                    root.right = it
                    rightRootList.add(root)
                    root = TreeNode(root.`val`)
                }
            }
            if (index >= 0) {
                val nodeList = subGenTrees(subArr.copyOfRange(0, index))
                if (rightRootList.isEmpty()) {
                    nodeList.forEach {
                        root.left = it
                        newRootList.add(root)
                        root = TreeNode(root.`val`)
                    }
                } else {
                    rightRootList.forEach { rightRoot ->
                        var newRightRoot = rightRoot
                        newRootList.add(newRightRoot)
                        nodeList.forEach { node ->
                            if (newRightRoot.left != null) {
                                newRightRoot = TreeNode(rightRoot.`val`)
                                newRightRoot.right = rightRoot.right
                                newRootList.add(newRightRoot)
                            }
                            newRightRoot.left = node
                        }
                    }
                }
            }
        }
        return newRootList
    }
}

fun main() {
    print(_95.generateTrees(4))
}
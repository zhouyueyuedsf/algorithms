package leetcode.array

import interview.chapter_9_others.Problem_09_MaxABSBetweenLeftAndRight

/**
 * @time 2020/5/23
 * @author joy zhou
 */


object _29 {
    // 矩阵分圈处理
    fun spiralOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.size == 0) return intArrayOf()
        val rows = matrix.size
        val cols = matrix[0].size
        val res = arrayListOf<Int>()
        // 找到左上角和右下角
        var left = 0
        var right = cols - 1
        var top = 0
        var bottom = rows - 1
        // 处理相等的情况
        while (right >= left && bottom >= top) {
            // 实际处理圈层
            helper(left, top, right, bottom, res, matrix)
            // 圈层缩小
            left++
            top++
            right--
            bottom--
        }
        return res.toIntArray()
    }

    private fun helper(_left: Int, _top: Int, _right: Int, _bottom: Int, res: ArrayList<Int>, matrix: Array<IntArray>) {
        var left = _left
        var top = _top
        var right = _right
        var bottom = _bottom

        if (left == right) {
            // 一列的情况
            while (top <= bottom) {
                res.add(matrix[top++][left])
            }
        } else if (top == bottom) {
            // 一行的情况
            while (left <= right) {
                res.add(matrix[top][left++])
            }
        } else {
            // 此处不能cover住所有的情况，因为一般情况是有头尾相连的，但是一行或者一列的时候是不会出现头尾相连的情况
            while (left < right) {
                res.add(matrix[top][left++])
            }
            while (top < bottom) {
                res.add(matrix[top++][left])
            }
            while (left > _left) {
                res.add(matrix[top][left--])
            }
            while (top > _top) {
                res.add(matrix[top--][left])
            }
        }
    }
}

fun main() {
    val intArray1 = intArrayOf(1, 2, 3, 4)
    val intArray2 = intArrayOf(5, 6, 7, 8)
    val intArray3 = intArrayOf(9, 10, 11, 12)
    val intArray4 = intArrayOf(13, 14, 15, 16)
    val input = arrayOf(intArray1, intArray2, intArray3, intArray4)
    _29.spiralOrder(input)
}
package leetcode.arrayandmatrix

import java.math.BigDecimal
import kotlin.math.pow

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入:
[
[1,1,1],
[1,0,1],
[1,1,1]
]
输出:
[
[1,0,1],
[0,0,0],
[1,0,1]
]
示例2:

输入:
[
[0,1,2,0],
[3,4,5,2],
[1,3,1,5]
]
输出:
[
[0,0,0,0],
[0,4,5,0],
[0,3,1,0]
]
进阶:

一个直接的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/set-matrix-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object _73 {

    fun setZeroes(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        if (m == 0) return
        val n = matrix[0].size

        var bitR = 0L
        var bitC = 0L
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    bitR = bitR or (2.0.pow(i).toLong())
                    bitC = bitC or (2.0.pow(j).toLong())
                }
            }
        }

        while (bitR != 0L) {
            val row = indexOfFirstOne(bitR)
            if (row != -1) {
                for (j in 0 until n) {
                    matrix[row][j] = 0
                }
            }
            bitR -= 2.0.pow(row).toInt()
        }

        while (bitC != 0L) {
            val col = indexOfFirstOne(bitC)
            if (col != -1) {
                for (i in 0 until m) {
                    matrix[i][col] = 0
                }
            }
            bitC -= 2.0.pow(col).toInt()
        }
    }

    fun indexOfFirstOne(n: Long): Int {
        var _n = n
        var res = 0
        while (_n != 0L) {
            _n = _n.shr(1)
            res++
        }
        return res - 1
    }

    fun setZeroes2(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        if (m == 0) return
        val n = matrix[0].size
        val flagCol = Int.MIN_VALUE + 1
        val flagRow = Int.MAX_VALUE - 1
        val flagBoth = Int.MAX_VALUE - 2
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        matrix[i][j] = flagBoth
                    } else {
                        // 计算是否行刷新，列刷新，都刷新
                        if (matrix[i][0] == flagCol || matrix[i][0] == flagBoth) {
                            matrix[i][0] = flagBoth
                        } else {
                            matrix[i][0] = flagRow
                        }
                        if (matrix[0][j] == flagRow || matrix[0][j] == flagBoth) {
                            matrix[0][j] = flagBoth
                        } else {
                            matrix[0][j] = flagCol
                        }
                    }
                }
            }
        }

        for (j in 0 until n) {
            if (matrix[0][j] == flagBoth) {
                for (i in 0 until m) {
                    if (matrix[i][0] != flagCol && matrix[i][0] != flagRow) {
                        matrix[i][0] = 0
                    }
                }
                for (k in 0 until n) {
                    if (matrix[0][k] != flagCol && matrix[0][k] != flagRow) {
                        matrix[0][k] = 0
                    }
                }
                continue
            }
            if (matrix[0][j] == flagCol) {
                // 刷新flagCol所在的列
                for (i in 0 until m) {
                    // 如果是被标记刷新
                    if (matrix[i][j] != flagRow) {
                        matrix[i][j] = 0
                    }
                }
            }
        }

        for (i in 0 until m) {
            if (matrix[i][0] == flagBoth) {
                for (k in 0 until m) {
                    if (matrix[i][0] != flagCol && matrix[i][0] != flagRow) {
                        matrix[i][0] = 0
                    }
                }
                for (j in 0 until n) {
                    if (matrix[0][j] != flagCol && matrix[0][j] != flagRow) {
                        matrix[0][j] = 0
                    }
                }
                continue
            }
            // 刷新flagRow所在的行
            if (matrix[i][0] == flagRow) {
                for (j in 0 until n) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}

fun main() {
    //[[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]
    // [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    // [[8,3,6,9,7,8,0,6],[0,3,7,0,0,4,3,8],[5,3,6,7,1,6,2,6],[8,7,2,5,0,6,4,0],[0,2,9,9,3,9,7,3]]
    val array1 = intArrayOf(1,2,3,4)
    val array2 = intArrayOf(5,0,7,8)
    val array3 = intArrayOf(0,10,11,12)
    val array4 = intArrayOf(13,14,15,0)
    val array5 = intArrayOf(0,1,2,0)
    val array6 = intArrayOf(3,4,5,2)
    val array7 = intArrayOf(1,3,1,5)
    val array8 = intArrayOf(8,3,6,9,7,8,0,6)
    val array9 = intArrayOf(0,3,7,0,0,4,3,8)
    val array10 = intArrayOf(5,3,6,7,1,6,2,6)
    val array11 = intArrayOf(8,7,2,5,0,6,4,0)
    val array12 = intArrayOf(0,2,9,9,3,9,7,3)
    val matrix1 = arrayOf(array1, array2, array3, array4)
    val matrix2 = arrayOf(array5, array6, array7)
    val matrix3 = arrayOf(array8, array9, array10, array11, array12)
    _73.setZeroes2(matrix2)
    print(matrix2)
}
package leetcode.arrayandmatrix

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？

 

示例 1:

给定 matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]
],

原地旋转输入矩阵，使其变为:
[
[7,4,1],
[8,5,2],
[9,6,3]
]
示例 2:

给定 matrix =
[
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
[15,13, 2, 5],
[14, 3, 4, 1],
[12, 6, 8, 9],
[16, 7,10,11]
]

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/array-and-string/clpgd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
object _48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        // 先转置在对称
        matrix.forEachIndexed { i, _ ->
            for (j in i until n) {
                val tmp = matrix[j][i]
                matrix[j][i] = matrix[i][j]
                matrix[i][j] = tmp
            }
        }


        val end = n / 2 - 1
        matrix.forEachIndexed { index, array ->
            for (j in 0..end) {
                val temp = array[j]
                array[j] = array[n - j - 1]
                array[n - j - 1] = temp
            }
        }
    }

    /**
     * 转圈打印
     */
    fun rotate2() {

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val array1 = intArrayOf(1, 2, 3)
        val array2 = intArrayOf(4, 5, 6)
        val array3 = intArrayOf(7, 8, 9)
        rotate(arrayOf(array1, array2, array3))
    }
}
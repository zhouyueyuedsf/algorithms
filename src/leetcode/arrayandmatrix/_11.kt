package leetcode.arrayandmatrix

import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    return dp(height)
}

/**
 * 简单的动态规划, 内存超出限制
 */
fun dp(height: IntArray): Int {
    val n = height.size
    val F = Array(n) { IntArray(n) }
    var i = 0
    var j = 1
    var initJ = 1
    while (j < n) {
        while (i < n && j < n) {
            if (i + 1 == j) {
                F[i][j] = min(height[i], height[j])
            } else {
                F[i][j] = max(F[i][j - 1], max(F[i + 1][j], (j - i) * min(height[i], height[j])))
            }
            i++
            j++
        }
        i = 0
        initJ++
        j = initJ
    }
    return F[0][n - 1]
}

/**
 * 双指针法，很简单，重要的是理解思想
 */
fun doublePointer(height: IntArray): Int {
    val n = height.size
    var headPoint = 0
    var tailPoint = n - 1
    var max = 0
    while (headPoint < tailPoint) {
        if (height[headPoint] < height[tailPoint]) {
            max = max(height[headPoint] * (tailPoint - headPoint), max)
            headPoint++
        } else {
            max = max(height[tailPoint] * (tailPoint - headPoint), max)
            tailPoint--
        }
    }
    return max
}

fun main() {
    println(doublePointer(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}
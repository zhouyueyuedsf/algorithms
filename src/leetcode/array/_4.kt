package leetcode.array

import kotlin.math.max
import kotlin.math.min


/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 **/

/**
 * 归并子过程，找到第k大的数，但时间复杂度不符合题目要求, 这里有和普通归并不太一样的边界处理, 其实还有一点不太一样，归并是为了排序，
 * 这里只是为了找到第(m + n) / 2小的值，这就可以产生更优的算法，如
 * @see findMedianSortedArrays
 */
fun merge(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    // 相当于，奇数直接取，偶数需要取前一位 / 2
    val midPos = (m + n).shr(1)
    var s1Index = 0
    var s2Index = 0
    var left = -1
    var right = -1
    for (index in 0 until midPos + 1) {
        left = right
        var s1Value = Int.MAX_VALUE
        var s2Value = Int.MAX_VALUE
        if (s1Index < m) s1Value = nums1[s1Index]
        if (s2Index < n) s2Value = nums2[s2Index]
        right = if (s1Value < s2Value) {
            s1Index++
            s1Value
        } else {
            s2Index++
            s2Value
        }
    }
    return if ((m + n).and(1) == 0) {
        (left + right).toDouble() / 2
    } else {
        right.toDouble()
    }
}

/**
 * 正解
 * 关键在与利用排好序的数组进行加速查找，类似于查找k小的方式去处理了
 * 在两个排好序的数组中 找到第k小的值
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    // 相当于，奇数直接取，偶数需要取前一位 / 2
    val midPos = (m + n).shr(1)
    var s1Index = 0
    var s2Index = 0
    var left = -1
    var right = -1
    var index = 0
    var curTargetPos = midPos
    while (index < midPos + 1) {
        left = right
        curTargetPos = if (curTargetPos.shr(1) == 0) 1 else curTargetPos.shr(1)
        var usedCount = 0
        val s1Delta = min(max(s1Index, m - 1), curTargetPos - 1)
        val s2Delta = min(max(s2Index, m - 1), curTargetPos - 1)
        val s1IndexTemp = s1Index + s1Delta
        val s2IndexTemp = s2Index + s2Delta
        var s1Value = Int.MAX_VALUE
        var s2Value = Int.MAX_VALUE
        if (s1IndexTemp < m) s1Value = nums1[s1IndexTemp]
        if (s2IndexTemp < n) s2Value = nums2[s2IndexTemp]
        right = if (s1Value < s2Value) {
            usedCount = s1Delta + 1
            s1Index += usedCount
            s1Value
        } else {
            usedCount = s2Delta + 1
            s2Index += usedCount
            s2Value
        }
        index += usedCount
    }
    return if ((m + n).and(1) == 0) {
        (left + right).toDouble() / 2
    } else {
        right.toDouble()
    }
}

fun main() {
    print(findMedianSortedArrays(intArrayOf(1, 1, 3, 3), intArrayOf(1, 1, 3, 3)))
}
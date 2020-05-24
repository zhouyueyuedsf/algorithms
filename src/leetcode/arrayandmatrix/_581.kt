package leetcode.arrayandmatrix

import java.lang.Integer.min
import kotlin.math.max

/**
 * @time 2020/5/23
 * @author joy zhou
 */
/**
 * 不同时的双指针
 */
object _581 {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var start = 0
        var cacheStart = -1
        for (index in nums.indices) {
            if (index + 1 < nums.size && nums[index] > nums[index + 1]) {
                start = index
                break
            }
        }
        var end = -1
        var cacheEnd = -1
        for (index in nums.size - 1 downTo 0) {
            if (index - 1 >= 0 && nums[index] < nums[index - 1]) {
                end = index
                break
            }
        }
        if (end == -1)  {
            return end - start + 1
        }
        var minV = Int.MAX_VALUE
        var maxV = Int.MIN_VALUE
        for (index in start .. end) {
            minV = min(nums[index], minV)
            maxV = max(nums[index], maxV)
        }
        var left = 0
        var right = 0
        for (index in start downTo 0) {
            if (minV >= nums[index]) {
                left = index + 1
                break
            } else {
                left = index
            }
        }
        for (index in end until nums.size) {
            if (maxV <= nums[index]) {
                right = index - 1
                break
            } else {
                right = index
            }
        }
//        while (start > 0) {
//            if (nums[--start] <= nums[end]) {
//                start++
//                break
//            }
//        }
//        while (end < nums.size - 1) {
//            if (nums[++end] >= nums[start]) {
//                break
//            }
//        }
        return right - left + 1
    }
}

fun main() {
    _581.findUnsortedSubarray(intArrayOf(1, 3, 2, 2, 2))
    _581.findUnsortedSubarray(intArrayOf(2, 3, 3, 2, 4))
    _581.findUnsortedSubarray(intArrayOf(1, 3, 5, 2, 4))
}
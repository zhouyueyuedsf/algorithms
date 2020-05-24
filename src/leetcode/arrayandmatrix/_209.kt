package leetcode.arrayandmatrix

import kotlin.math.min

/**
 * @time 2020/5/23
 * @author joy zhou
 */

object _209 {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var left = 0
        var right = 0
        var sum = nums[left]
        var len = Int.MAX_VALUE
        while (left <= right && right < nums.size) {
            if (sum < s) {
                if (right + 1 == nums.size) break
                right++
                sum += nums[right]
            } else {
                len = min(right - left + 1, len)
                sum -= nums[left]
                left++
            }
        }
        return if (len == Int.MAX_VALUE) 0 else len
    }
}

fun main() {
    println(_209.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
}
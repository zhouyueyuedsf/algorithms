package leetcode.array

import leetcode.array._16.threeSumClosest
import leetcode.array._16.threeSumClosest2
import kotlin.math.abs
import kotlin.math.min

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object _16 {
    /**
     *  此题分析题目是是关键，见三星note笔记
     */
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        val minSumList = sortedSetOf<Int>()
        val size = nums.size
        var anchorIndex = size - 1
        var res = 0
        var curMin = Int.MAX_VALUE - abs(target)
        for (index in nums.indices) {
            val anchor = nums[anchorIndex]
            var left = 0
            var right = anchorIndex - 1
            var leftMinSum = Int.MAX_VALUE - abs(target)
            var rightMinSum = Int.MAX_VALUE - abs(target)
            while (left < right) {
                val sum = nums[left] + nums[right] + anchor
                when {
                    sum < target -> {
                        left++
                        leftMinSum = sum
                    }
                    sum > target -> {
                        right--
                        rightMinSum = sum
                    }
                    else -> {
                        return sum
                    }
                }
            }
            if (abs(leftMinSum - target) < abs(rightMinSum - target)) {
                if (curMin > abs(leftMinSum - target)) {
                    curMin = abs(leftMinSum - target)
                    res = leftMinSum
                }
            } else {
                if (curMin > abs(rightMinSum - target)) {
                    curMin = abs(rightMinSum - target)
                    res = rightMinSum
                }
            }
            anchorIndex--
        }
        return res
    }

    /**
     * 去掉了冗余代码
     */
    fun threeSumClosest2(nums: IntArray, target: Int): Int {
        nums.sort()
        val minSumList = sortedSetOf<Int>()
        val size = nums.size
        var anchorIndex = size - 1
        var res = Int.MAX_VALUE - abs(target)
        for (index in nums.indices) {
            val anchor = nums[anchorIndex]
            var left = 0
            var right = anchorIndex - 1
            while (left < right) {
                val sum = nums[left] + nums[right] + anchor
                if (abs(sum - target) < abs(res - target)) {
                    res = sum
                }
                when {
                    sum < target -> {
                        left++
                    }
                    sum > target -> {
                        right--
                    }
                    else -> {
                        return sum
                    }
                }
            }
            anchorIndex--
        }
        return res
    }
}

fun main() {
    println(threeSumClosest2(intArrayOf(-3, -2, -5, 3, -4), -1))
}

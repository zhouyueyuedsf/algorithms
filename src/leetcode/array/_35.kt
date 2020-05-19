package leetcode.array

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，
 * 并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
object _35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        var mid = 0
        var index = 0
        while (start <= end) {
            mid = (start + end) / 2
            if (nums[mid] < target) {
                start = mid + 1
                index = mid + 1
            } else if (nums[mid] > target) {
                end = mid - 1
                index = mid
            } else {
                // 得到结果
                index = mid
                break
            }
        }
        return index
    }

    fun searchInsert2(nums: IntArray, target: Int): Int {
        var left = 0
        var right: Int = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                nums[mid] == target -> {
                    return mid
                }
                nums[mid] < target -> {
                    left = mid + 1
                }
                else -> {
                    right = mid - 1
                }
            }
        }
        // 为什么不返回right ， (3 + 4) / 2 = 3, (left + right) / 2 接近于 right
        return left
    }
}

fun main() {
    println(_35.searchInsert2(intArrayOf(1, 3, 5, 6), 7))
}
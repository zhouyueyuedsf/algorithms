package leetcode.binarysearch

/**
 * @time 2020/5/15
 * @author joy zhou
 */
/**
 * 边界控制
 */
object _33 {
    fun search(nums: IntArray, target: Int): Int {
        return helper(nums, 0, nums.size - 1, target)
    }

    private fun helper(nums: IntArray, start: Int, end: Int, target: Int): Int {
        if (start > end) {
            return -1
        }
        if (start == end) {
            return if (target == nums[start]) return start else -1
        }
        val mid = (start + end) / 2

        if (nums[start] > nums[mid]) {
            // 边界控制比较重要
            if (target >= nums[mid + 1] && target <= nums[end]) {
                return helper(nums, mid + 1, end, target)
            } else {
                return helper(nums, start, mid, target)
            }
        } else if (nums[start] < nums[mid]){
            if (target <= nums[mid] && target >= nums[start]) {
                return helper(nums, start, mid, target)
            } else {
                return helper(nums, mid + 1, end, target)
            }
        }
        if (target == nums[mid]) return mid
        if (target == nums[mid + 1]) return mid + 1
        return -1
    }
}

fun main() {
    println(_33.search(intArrayOf(2), 1))
}
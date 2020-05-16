package leetcode.binarysearch

/**
 * @time 2020/5/16
 * @author joy zhou
 */

/**
 * 感觉二分法的边界好多
 */
object  _34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        helper(nums, 0, nums.size - 1, target)
        if (res.isEmpty()) return intArrayOf(-1, -1)
        if (res.size == 1) return intArrayOf(res[0], res[0])
        return res.toIntArray()
    }
    val res = arrayListOf<Int>()
    fun helper(nums: IntArray, start: Int, end: Int, target: Int) {
        if (start > end) return
        val mid = (start + end) / 2
        if (nums[mid] >= target) {
            if (mid >= 1 && nums[mid - 1] != target && nums[mid] == target) {
                res.add(mid)
            } else {
                if (mid < 1 && nums[mid] == target) {
                    res.add(mid)
                }
                helper(nums, start, mid - 1, target)
            }
        }
        if (nums[mid] <= target) {
            if (mid + 1 < nums.size && nums[mid + 1] != target && nums[mid] == target) {
                res.add(mid)
            } else {
                if (mid + 1 >= nums.size && nums[mid] == target) {
                    res.add(mid)
                }
                helper(nums, mid + 1, end, target)
            }
        }
    }
}

fun main() {
    println(_34.searchRange(intArrayOf(8, 8), 8))
}
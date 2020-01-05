package leetcode.array

/**
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
 **/

// 暴力法省略

// 一次遍历hash
// 可以遍历的根本原因是a+b=t, 那么其差值集合{t-b, t-a}必然存在一个前后的顺序关系，所以最终就一定能找到
object _1{
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // 可以用spasreArray
        val map = hashMapOf<Int, Int>()
        for (index in nums.indices) {
            val reduction = target - nums[index]
            if (map.containsKey(reduction)) {
                return intArrayOf(map[reduction]!!, index)
            }
            map[nums[index]] = index
        }
        return intArrayOf(-1, -1)
    }

    /**
     * 双指针，这里的缺点就是很难找到对应的index，在指定效率上只能找到对应的值
     */
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        nums.sort()
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val guideValue = nums[start] + nums[end]
            when {
                guideValue < target -> {
                    start++
                }
                guideValue > target -> {
                    end--
                }
                else -> {
                    return intArrayOf(nums[start], nums[end])
                }
            }
        }
        return intArrayOf(-1, -1)
    }

}

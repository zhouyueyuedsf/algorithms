package leetcode.arrayandmatrix



/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
[-1,  0, 0, 1],
[-2, -1, 1, 2],
[-2,  0, 0, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


object _18 {
    /**
     * 四数之和等于某个定值，没什么特别的解法和三数之和相同
     */
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val result: MutableList<List<Int>> = ArrayList(8)
        val len = nums.size
        if (len < 4) {
            return result
        }
        var minValue: Int = nums.get(0) + nums.get(1) + nums.get(2) + nums.get(3)
        var maxValue: Int = nums.get(len - 1) + nums.get(len - 2) + nums.get(len - 3) + nums.get(len - 4)
        if (maxValue < target || minValue > target) {
            return result
        }
        var left = 2
        var right = len - 1
        //第一个固定值的值
        //第一个固定值的值
        var oneValue = 0
        //第2个固定值的值
        //第2个固定值的值
        var twoValue = 0
        var fourNumSum = 0
        for (one in 0..len - 4) {
            oneValue = nums.get(one)
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue
            }
            for (two in one + 1..len - 3) {
                if (two > one + 1 && nums[two] == nums[two - 1]) {
                    continue
                }
                twoValue = nums.get(two)
                left = two + 1
                right = len - 1
                minValue = oneValue + twoValue + nums[two + 1] + nums[two + 2]
                maxValue = oneValue + twoValue + nums[len - 2] + nums[len - 1]
                if (maxValue < target || minValue > target) {
                    left = right
                }
                while (left < right) {
                    fourNumSum = nums.get(left) + nums.get(right) + oneValue + twoValue
                    if (fourNumSum > target) {
                        right--
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--
                        }
                    } else if (fourNumSum < target) {
                        left++
                        while (right > left && nums[left] == nums[left - 1]) {
                            left++
                        }
                    } else {
                        val resultOne: MutableList<Int> = ArrayList(4)
                        resultOne.add(oneValue)
                        resultOne.add(twoValue)
                        resultOne.add(nums.get(left))
                        resultOne.add(nums.get(right))
                        result.add(resultOne)
                        left++
                        right--
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--
                        }
                        while (right > left && nums[left] == nums[left - 1]) {
                            left++
                        }
                    }
                }
            }
        }
        return result
    }
}
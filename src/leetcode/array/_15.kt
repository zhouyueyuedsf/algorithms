package leetcode.array

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
[-1, 0, 1],
[-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 双指针
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val res = arrayListOf<List<Int>>()
    val keySet = hashSetOf<String>()
    nums.sort()
    for (i in nums.indices) {
        val target = 0 - nums[i]
//        var start = i
        var start = i + 1
        var end = nums.size - 1
        while (start < end) {
            if (i == start) {
                start++
                continue
            }
            if (i == end) {
                end--
                continue
            }
            val guideValue = nums[start] + nums[end]
            when {
                guideValue < target -> {
                    start++
                }
                guideValue > target -> {
                    end--
                }
                else -> {
                    // 相等后
                    val itemList = arrayListOf<Int>()
                    itemList.add(-target)
                    itemList.add(nums[start])
                    itemList.add(nums[end])
                    val key = itemList.toString()
                    if (!keySet.contains(key)) {
                        keySet.add(itemList.toString())
                        res.add(itemList)
                    }
                    start++
                }
            }
        }
    }
    return res
}

/**
 * 优化算法，不需要用hashset判断重复, 由于顺序性
 */
fun threeSum2(nums: IntArray): List<List<Int>> {
    val ans = arrayListOf<List<Int>>()
    val len = nums.size
    if (len < 3) return ans
    nums.sort()
    for (i in 0 until len) {
        if (nums[i] > 0) break // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
        if (i > 0 && nums[i] == nums[i - 1]) continue  // 去重
        var L = i + 1
        var R = len - 1
        while (L < R) {
            val sum: Int = nums[i] + nums[L] + nums[R]
            when {
                sum == 0 -> {
                    ans.add(listOf(nums[i], nums[L], nums[R]))
                    while (L < R && nums[L] == nums[L + 1]) L++ // 去重
                    while (L < R && nums[R] == nums[R - 1]) R-- // 去重
                    L++
                    R--
                }
                sum < 0 -> L++
                sum > 0 -> R--
            }
        }
    }
    return ans
}
fun main() {
    println(threeSum2(intArrayOf(-5, -2, 7)))
}
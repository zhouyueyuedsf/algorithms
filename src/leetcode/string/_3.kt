package leetcode.string

import kotlin.math.max

object _3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val array = arrayOfNulls<Int>(256)
        // 用双指针取出字串
        // 如何判断start++
        var start = 0
        // 如何判断end++
        var end = 0
        val size = s.length
        var max = 0
        while (end < size) {
            // 例用char的字符编码做一个映射表
            // curCharInt：end索引对应的字符的Int表示
            val curCharInt = s[end].toInt()
            // curCharInt对应的最新（最大）的索引
            val curCharIndex = array[curCharInt]
            if (curCharIndex == null || curCharIndex < start) {
                // curIndex < start即当前char对应得最新索引不在start-end的范围内，
                // 说明该char也有效，需要重新计算max
                max = max(end - start + 1, max)
            } else {
                start = curCharIndex + 1
            }
            // 更新最新的映射表即curCharInt永远对应的是最新的end
            array[curCharInt] = end
            end++
        }
        return max
    }
}

fun main() {
    val input = "tmmzuxt"
    val input2 = "abcabcbb"
    val input3 = "bbbbbb"
    val input4 = "pwwkew"
    println(_3.lengthOfLongestSubstring(input))
    println(_3.lengthOfLongestSubstring(input2))
    println(_3.lengthOfLongestSubstring(input3))
    println(_3.lengthOfLongestSubstring(input4))
}
package leetcode.string

import kotlin.math.min

/**
 * @time 2020/6/26
 * @author joy zhou
 */

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */

object _76 {
    /**
     * 滑动窗口算法
     */
    fun minWindow(s: String, t: String): String {
        val arrayMap = Array<Int>(256) { 0 }
        t.forEach {
            arrayMap[it.toInt()] += 1
        }
        var unMatchCount = t.length
        var resLeft = 0
        var resRight = 0
        var minDistance = Int.MAX_VALUE
        var left = 0
        var right = 0
        var res = 0
        while (right < s.length) {
            //
            arrayMap[s[right].toInt()]--
            if (arrayMap[s[right].toInt()] >= 0) {
                unMatchCount--
                // unMatchCount != 0 right 移动
                if (unMatchCount == 0) {
                    // 匹配，滑动left以重新匹配
                    while (arrayMap[s[left].toInt()] < 0) {
                        arrayMap[s[left].toInt()]++
                        left++
                    }
                    if (minDistance > right - left + 1) {
                        resRight = right
                        resLeft = left
                        minDistance = right - left + 1
                    }
                    unMatchCount++
                    arrayMap[s[left].toInt()]++
                    left++
                }
                right++
            } else {
                right++
            }
        }
        return if (minDistance == Int.MAX_VALUE) "" else s.substring(resLeft, resRight + 1)
    }
}

fun main() {
    val s = "a"
    val t = "aa"
    println(_76.minWindow(s, t))
}
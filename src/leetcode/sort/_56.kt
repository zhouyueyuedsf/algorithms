package leetcode.sort

import leetcode.array.merge
import kotlin.math.max
import kotlin.math.min

/**
 * @time 2020/5/12
 * @author joy zhou
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


data class Section(var start: Int, var end: Int) : Comparable<Section> {
    override fun compareTo(other: Section): Int {
        // 贪心，以第一节点排序
        return start - other.start
    }
}

object _56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) return intervals
        val sectionList = arrayListOf<Section>()
        intervals.forEach {
            sectionList.add(Section(it[0], it[1]))
        }
        sectionList.sort()
        val arrayList = arrayListOf<IntArray>()
        var anchor = Section(sectionList[0].start, sectionList[0].end)
        for (index in 1 until sectionList.size) {
            val candidate = sectionList[index]
            anchor = if (anchor.end >= candidate.start) {
                val min = min(anchor.start, candidate.start)
                val max = max(anchor.end, candidate.end)
                Section(min, max)
            } else {
                arrayList.add(intArrayOf(anchor.start, anchor.end))
                candidate
            }
        }
        arrayList.add(intArrayOf(anchor.start, anchor.end))
        return arrayList.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val input = arrayOf(intArrayOf(2, 3), intArrayOf(4, 5), intArrayOf(1, 6))
    _56.merge(input)
}
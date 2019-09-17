package leetcode.other

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
    val array = arrayOf(intArrayOf(84, 250), intArrayOf(0, 0), intArrayOf(1, 0),
            intArrayOf(0, -70), intArrayOf(0, -70), intArrayOf(1, -1),
            intArrayOf(21, 10), intArrayOf(42, 90), intArrayOf(-42, -230))
    print(maxPoints(array))
}

fun maxPoints(points: Array<IntArray>): Int {
    val size = points.size

    if (size == 1) return 1
    /**
     * 结果值
     */
    var res = Int.MIN_VALUE
    var resKey: String? = null
    val buckets = HashMap<String, HashSet<Pair<Int, Int>>>()
    for (i in 0 until size) {
        val anchorPoint = Pair<Int, Int>(points[i][0], points[i][1])
        for (j in i + 1 until size) {
            val selectPoint = Pair<Int, Int>(points[j][0], points[j][1])
            var k: Float
            var b: Float
            if (anchorPoint.first == selectPoint.first) {
                // 坐标x相等，此时设k为MAX_VALUE和b为x值
                k = Float.MAX_VALUE
                b = anchorPoint.first.toFloat()
            } else {
                k = (selectPoint.second - anchorPoint.second) / (selectPoint.first - anchorPoint.first).toFloat()
                b = anchorPoint.second - k * anchorPoint.first
            }
            val key = genKey(k, b)
            if (buckets[key] == null) {
                val set = HashSet<Pair<Int, Int>>()
                set.add(anchorPoint)
                set.add(selectPoint)
                buckets[key] = set
            } else {
                val set = buckets[key]
                set?.add(anchorPoint)
                set?.add(selectPoint)
            }
            if (res < buckets[key]!!.size) {
                res = buckets[key]!!.size
                resKey = key
            }
        }
    }
    res = 0
    if (resKey != null) {
        for (v in buckets[resKey]!!) {
            for (point in points) {
                if (v.first == point[0] && v.second == point[1]) {
                    res++
                }
            }
        }
    }

    return res
}

fun genKey(k: Float, b: Float): String{
    val kString: String = Formatter().format("%.6f", k).toString()
    val bString: String = Formatter().format("%.6f", b).toString()
    return "k=$kString b=$bString"
}

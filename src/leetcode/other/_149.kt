package leetcode.other

import common.ArrayClass
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.max

fun main() {

    val array = ArrayClass.stringToIntArray("[[560,248],[0,16],[30,250],[950,187],[630,277],[950,187],[-212,-268],[-287,-222],[53,37],[-280,-100],[-1,-14],[-5,4],[-35,-387],[-95,11],[-70,-13],[-700,-274],[-95,11],[-2,-33],[3,62],[-4,-47],[106,98],[-7,-65],[-8,-71],[-8,-147],[5,5],[-5,-90],[-420,-158],[-420,-158],[-350,-129],[-475,-53],[-4,-47],[-380,-37],[0,-24],[35,299],[-8,-71],[-2,-6],[8,25],[6,13],[-106,-146],[53,37],[-7,-128],[-5,-1],[-318,-390],[-15,-191],[-665,-85],[318,342],[7,138],[-570,-69],[-9,-4],[0,-9],[1,-7],[-51,23],[4,1],[-7,5],[-280,-100],[700,306],[0,-23],[-7,-4],[-246,-184],[350,161],[-424,-512],[35,299],[0,-24],[-140,-42],[-760,-101],[-9,-9],[140,74],[-285,-21],[-350,-129],[-6,9],[-630,-245],[700,306],[1,-17],[0,16],[-70,-13],[1,24],[-328,-260],[-34,26],[7,-5],[-371,-451],[-570,-69],[0,27],[-7,-65],[-9,-166],[-475,-53],[-68,20],[210,103],[700,306],[7,-6],[-3,-52],[-106,-146],[560,248],[10,6],[6,119],[0,2],[-41,6],[7,19],[30,250]]")
    print(maxPoints(array))
}

fun maxPoints(points: Array<IntArray>): Int {
    val size = points.size
    if (size == 0) return 0
    if (size == 1) return 1
    var res = 0

    for (i in 0 until size) {
        val anchorPoint = Pair<Int, Int>(points[i][0], points[i][1])
        val buckets = HashMap<String, Int>()
        var repeat = 0
        var tmp_max = 0
        for (j in i + 1 until size) {
            val selectPoint = Pair<Int, Int>(points[j][0], points[j][1])
            var dx: Int
            var dy: Int
            dx = (selectPoint.first - anchorPoint.first)
            dy = (selectPoint.second - anchorPoint.second)
            if (dy == 0 && dx == 0) {
                repeat++
                continue
            }
            // 该方法很重要
            val g = gcd(dy, dx)
            if (g != 0) {
                dy /= g
                dx /= g
            }
            val tmp = "$dy/$dx"
            buckets[tmp] = buckets.getOrDefault(tmp, 0) + 1
            tmp_max = max(tmp_max, buckets[tmp]!!)
        }
        res = max(res, repeat + tmp_max + 1)
    }
    return res
}

private fun gcd(dy: Int, dx: Int): Int {
    return if (dx == 0)
        dy
    else
        gcd(dx, dy % dx)
}

fun genKey(dy: Int, dx: Int, maybeX: Int): String {
    val g = gcd(dy, dx)
    var y = 0
    var x = 0
    if (g != 0) {
        y = dy / g
        x = dx / g
    }
    if (dx == 0) {
        return "${maybeX}k=$y b=$x"
    }
//    val kString: String = Formatter().format("%.6f", k).toString()
//    val bString: String = Formatter().format("%.6f", b).toString()
    return "k=$y b=$x"
}

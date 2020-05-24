package leetcode.arrayandmatrix

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs
import kotlin.math.min

object _934 {
    private val island1HashMap = hashMapOf<String, IntArray>()
    private val island2HashMap = hashMapOf<String, IntArray>()
    fun shortestBridge(A: Array<IntArray>): Int {
        var res = Int.MAX_VALUE
        var count = 0
        loop@ for (i in A.indices) {
            for (j in A[i].indices) {
                if (A[i][j] == 1) {
                    if (island1HashMap.isEmpty() && !isVisit(island1HashMap, i, j)) {
                        flag(A, i, j, island1HashMap)
                    } else if (!isVisit(island1HashMap, i, j) && island2HashMap.isEmpty() && !isVisit(island2HashMap, i, j)){
                        flag(A, i, j, island2HashMap)
                        break@loop
                    }
                }
            }
        }

        island1HashMap.forEach {
            res = min(res, bfs(A, it.value[0], it.value[1]))
        }

        return res
    }

    fun flag(A: Array<IntArray>, row: Int, col: Int, hashMap: HashMap<String, IntArray>) {
        val queue = LinkedList<IntArray>()
        val rows = A.size - 1
        val cols = A[0].size - 1
        queue.add(intArrayOf(row, col))
        while (queue.isNotEmpty()) {
            val anchor = queue.poll()
            val i = anchor[0]
            val j = anchor[1]
            setVisit(hashMap, i, j)
            if (i + 1 <= rows && !isVisit(hashMap, i + 1, j)) {
                if (A[i + 1][j] == 1) {
                    queue.add(intArrayOf(i + 1, j))
                }
            }
            if (j + 1 <= cols && !isVisit(hashMap, i, j + 1)) {
                if (A[i][j + 1] == 1) {
                    queue.add(intArrayOf(i, j + 1))
                }
            }
            if (i - 1 >= 0 && !isVisit(hashMap, i - 1, j)) {
                if (A[i - 1][j] == 1) {
                    queue.add(intArrayOf(i - 1, j))
                }
            }
            if (j - 1 >= 0 && !isVisit(hashMap, i, j - 1)) {
                if (A[i][j - 1] == 1) {
                    queue.add(intArrayOf(i, j - 1))
                }
            }
        }
    }
    fun bfs(A: Array<IntArray>, row: Int, col: Int): Int {
        val queue = LinkedList<IntArray>()
        val rows = A.size - 1
        val cols = A[0].size - 1
        queue.add(intArrayOf(row, col))
        var i = row
        var j = col
        val hashMap = hashMapOf<String, IntArray>()
        var count = 0
        while (queue.isNotEmpty()) {
            val anchor = queue.poll()
            i = anchor[0]
            j = anchor[1]
            println("${A[i][j]} and i = $i and j = $j")
            if (i + 1 <= rows) {
                if (!isVisit(hashMap, i + 1, j)) {
                    queue.add(intArrayOf(i + 1, j))
                }
            }
            if (j + 1 <= cols) {
                if (!isVisit(hashMap, i, j + 1)) {
                    queue.add(intArrayOf(i, j + 1))
                }
            }
            if (i - 1 >= 0) {
                if (!isVisit(hashMap, i - 1, j)) {
                    queue.add(intArrayOf(i - 1, j))
                }
            }
            if (j - 1 >= 0) {
                if (!isVisit(hashMap, i, j - 1)) {
                    queue.add(intArrayOf(i, j - 1))
                }
            }
            setVisit(hashMap, i, j)
            if (isVisit(island2HashMap, i, j)) {
                break
            }
        }

        return abs(i - row) + abs(j - col) - 1
    }

    fun setVisit(hashMap: HashMap<String, IntArray>, i: Int, j: Int) {
        hashMap["$i, $j"] = intArrayOf(i, j)
    }

    fun isVisit(hashMap: HashMap<String, IntArray>, i: Int, j: Int): Boolean {
        return hashMap.containsKey("$i, $j")
    }
}

fun main() {
    val intArray1 = intArrayOf(1, 1, 0, 0)
    val intArray2 = intArrayOf(1, 0, 0, 0)
    val intArray3 = intArrayOf(0, 0, 0, 1)
    val intArray4 = intArrayOf(0, 0, 0, 0)
    val intArray5 = intArrayOf(0,1)
    val intArray6 = intArrayOf(1,0)
    val input = arrayOf(intArray1, intArray2, intArray3)
    val input2 = arrayOf(intArray5, intArray6)
    val intArray3_1 = intArrayOf(0, 0, 0, 0, 0, 0, 0)
    val intArray3_2 = intArrayOf(1, 0, 0, 1, 0, 0, 0)
    val intArray3_3 = intArrayOf(1, 1, 1, 1, 0, 0, 0)
    val intArray3_4 = intArrayOf(0, 0, 0, 1, 0, 0, 0)
    val intArray3_5 = intArrayOf(1, 0, 0, 0, 0, 0, 0)
    val intArray3_6 = intArrayOf(1, 1, 0, 0, 0, 0, 0)
    val intArray3_7 = intArrayOf(1, 0, 0, 0, 0, 0, 0)
    val input3 = arrayOf(intArray3_1, intArray3_2, intArray3_3, intArray3_4, intArray3_5, intArray3_6, intArray3_7)
    print("res = ${_934.shortestBridge(input3)}")
}
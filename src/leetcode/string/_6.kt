package leetcode.string

import java.lang.StringBuilder

object _6 {
    fun convert(s: String, numRows: Int): String {
        val list = Array<ArrayList<Char>>(numRows) {
            arrayListOf()
        }
        s.forEachIndexed { index, c ->
            val mod = index / (numRows - 1)
            val remain = index % (numRows - 1)
            if (mod % 2 == 0) {
                // 偶数
                list[remain].add(c)
            } else {
                // 奇数
                list[numRows - remain - 1].add(c)
            }
        }
        val builder = StringBuilder()
        list.forEach { internList ->
            internList.forEach {
                builder.append(it)
            }
        }
        return builder.toString()
    }
}

fun main() {
    val inputStr = "LDREOEIIECIHNTSG"
    print(_6.convert(inputStr, 4))
}
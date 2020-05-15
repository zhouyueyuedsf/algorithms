package leetcode.backtracking

import java.util.*
import kotlin.collections.ArrayList


/**
 * @time 2020/5/14
 * @author joy zhou
 */

object _17 {
    var output: ArrayList<String> = arrayListOf()
    var phone: Map<Char, String> = object : HashMap<Char, String>() {
        init {
            put('2', "abc")
            put('3', "def")
            put('4',"ghi")
            put('5', "jkl")
            put('6', "mno")
            put('7', "pqrs")
            put('8', "tuv")
            put('9', "wxyz")
        }
    }
    // 生成一棵树
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val nodesList = arrayListOf<String>()
        digits.forEach {
            val v = phone[it]
            if (v != null) {
                nodesList.add(v)
            }
        }
        backtrack(nodesList, 0, "")
        return output
    }

    fun backtrack(nodesList: List<String>, index: Int, s: String) {
        if (index == nodesList.size) {
            output.add(s)
            return
        }
        val nodes = nodesList[index]
        nodes.forEach {
            backtrack(nodesList, index + 1, s + it)
        }
    }
}

fun main() {
    _17.letterCombinations("")
}
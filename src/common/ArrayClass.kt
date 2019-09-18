package common

import java.util.*

object ArrayClass {
    //    [[1,2],[3,4]]
    fun stringToIntArray(str: String): Array<IntArray> {

        val res = arrayListOf<IntArray>()
        var curNum = ""
        val stack = Stack<Char>()
        for (c in str) {
            when (c) {
                '[' -> {
                    stack.push(c)
                }
                ']' -> {
                    val curArrList = arrayListOf<Int>()
                    var cTemp = stack.pop()
                    while (cTemp != '[') {
                        while (cTemp != ',' && cTemp != '[') {
                            curNum = cTemp + curNum
                            cTemp = stack.pop()
                        }
                        curArrList.add(0, curNum.toInt())
                        curNum = ""
                        if (!stack.empty() && cTemp != '[') {
                            cTemp = stack.pop()
                        }
                    }
                    if (!curArrList.isEmpty()) {
                        res.add(curArrList.toIntArray())
                    }
                }
                else -> {
                    if (c == ',' && !stack.empty() && stack.peek() != '[') {
                        stack.push(c)
                    }
                    if (c != ',') {
                        stack.push(c)
                    }
                }
            }
        }
        val resArr = Array<IntArray>(size = res.size, init = {
            res[it]
        })
//        res.toArray(resArr)
        return resArr
    }
}

fun main() {
    val arr = ArrayClass.stringToIntArray("[[1,2],[3,4]]")
    print(arr)
}
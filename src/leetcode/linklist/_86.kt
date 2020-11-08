package leetcode.linklist

import common.LinkedListClass
import common.ListNode

object _86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val guardNode = ListNode(0)
        // 小于x的链表的尾部
        var smallTail = guardNode
        smallTail.next = head
        var cur = head
        var pre = guardNode
        while (cur != null) {
            if (cur.`val` < x) {
                val localCur = cur
                // 移除当前节点
                pre.next = localCur.next
                localCur.next = null
                // 再把当前节点已到smallTail的尾部
                val temp = smallTail.next
                smallTail.next = localCur
                smallTail = localCur
                smallTail.next = temp
            }
            // 保存删除必要的pre节点
            pre = cur
            // 单次遍历
            cur = cur.next
        }
        return guardNode.next
    }
}

fun main() {
    _86.partition(LinkedListClass.ArrayToList("1,4,3,2,5,2"), 3)
}
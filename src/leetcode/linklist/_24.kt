package leetcode.linklist

import common.LinkedListClass
import common.ListNode

object _24 {
    fun swapPairs(head: ListNode?): ListNode? {
        var cur = head
        while (cur != null) {
            var pre = cur.next.next
            var (firstHead, firstFail) = reverse(cur, 2)
//            firstFail.next = reverse(firstFail.next, 2).first
                    }
//        return firstHead
    }

    /**
     * 反转从head开始的后的第k个节点
     */
    fun reverse(head: ListNode?, k: Int): Pair<ListNode?, ListNode?> {
        var localHead = head
        var pre: ListNode? = null
        var i = 0;
        while (localHead != null && i < k) {
            var next = localHead.next
            localHead.next = pre
            pre = localHead
            localHead = next
            i++
        }
        return Pair(pre, head)
    }
}

fun main() {
    _24.swapPairs(LinkedListClass.ArrayToList("1,2,3,4"))
}
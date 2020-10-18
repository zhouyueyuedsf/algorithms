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
        return cur
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

    fun reverse2(head: ListNode?): ListNode? {
        var pre: ListNode = ListNode(0)
        var localPre = pre
        var localHead = head
        while (localHead?.next != null) {
            val next = localHead.next
            localPre.next = next
            localPre = localHead
            localHead = next.next
            next.next = localPre
        }
        if (localHead?.next == null) {
            localPre.next = localHead
        }
        return pre.next
    }

    fun reverse3(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val next = head.next
        head.next = reverse3(next.next)
        next.next = head
        return next
    }
}

fun main() {
    _24.reverse2(LinkedListClass.ArrayToList("1,2,3,4,5"))
}
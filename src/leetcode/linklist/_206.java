package leetcode.linklist;

import common.LinkedListClass;
import common.ListNode;

public class _206 {
    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public static void main(String[] args) {
        ListNode node = reverseList(LinkedListClass.ArrayToList("1,2,3,4,5,6"));
        System.out.println(1);
    }
}

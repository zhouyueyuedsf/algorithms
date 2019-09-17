package leetcode.linklist;

import common.LinkedListClass;
import common.ListNode;

public class _206 {
    /**
     * 递归反转
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private static ListNode reverseList2(ListNode head) {
        ListNode s = head.next;
        head.next = null;
        ListNode s1 = null;
        while (s != null) {
            s1 = s.next;
            s.next = head;
            head = s;
            s = s1;
        }
        return head;
    }

    private static ListNode reverseList3(ListNode head) {
        ListNode n1 = null;
        ListNode n2 = null;
        while(head != null){
            n2 = head.next;
            head.next = n1;
            n1 = head;

            head = n2;
        }
        return n1;
    }
    public static void main(String[] args) {
        ListNode node = reverseList3(LinkedListClass.ArrayToList("1,2,3,4,5,6"));
        System.out.println(1);
    }
}

package niuke.linklist;

import common.LinkedListClass;
import common.ListNode;

public class 删除链表中重复的结点 {


    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode cur = pHead;
        ListNode before = null;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int val = cur.val;
                while (cur.next != null && val == cur.next.val) {
                    cur = cur.next;
                }
                if (before == null) {
                    pHead = cur.next;
                } else {
                    before.next = cur.next;
                }
            } else {
                before = cur;
            }
            cur = cur.next;
        }
        return pHead;
    }

    private ListNode deleteOneNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        if (pHead.next == null) {
            pHead = null;
            return null;
        }

        pHead.val = pHead.next.val;
        pHead.next = pHead.next.next;
        return pHead;
    }

    public static void main(String[] args) {
        ListNode node = LinkedListClass.ArrayToList("1,1");

        删除链表中重复的结点 run = new 删除链表中重复的结点();
        run.deleteDuplication(node);
        System.out.println(node);
    }
}

package niuke.linklist;

import common.LinkedListClass;
import common.ListNode;

public class 删除链表的倒数第N个节点 {

    /**
     * 双指针模型
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        ListNode head2 = head;
        if (n == 1) {
            while (head.next != null && head.next.next != null) {
                head = head.next;
            }
            if (head.next == null) {
                dummy = null;
            } else {
                head.next = null;
            }
            return dummy;
        }

        for (int i = 0; i < n ; i++) {
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            head2 = head2.next;
        }
        head2.val = head2.next.val;
        head2.next = head2.next.next;
        return dummy;
    }
    public static void main(String[] args) {
        ListNode node = LinkedListClass.ArrayToList("1");
        删除链表的倒数第N个节点 run = new 删除链表的倒数第N个节点();
        node = run.removeNthFromEnd(node,1);
        LinkedListClass.print(node);
    }
}

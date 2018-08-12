package niuke.linklist;

import common.ListNode;

public class 删除链表中的节点 {

    /**
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        //链表中哨兵也很重要
        dummy.next = head;
        head = dummy;
        while(head.next != null){
            if(head.next.val == val){
                //删除节点后不需要移动，因为要保持一个前后的关系
                head.next = head.next.next;
            } else {
                // 单链表保持一个前后关系很重要
                head = head.next;
            }
        }
        return dummy.next;
    }

    /**
     * 删除指定节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {

    }
}

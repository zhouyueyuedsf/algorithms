package common;

public class LinkedListClass {


    public static ListNode ArrayToList(String input) {
        String[] strObjs = input.split(",");
        ListNode head = new ListNode(Integer.valueOf(strObjs[0]));
        ListNode cur = head;
        for (int i = 1; i < strObjs.length; i++) {
            int val = Integer.valueOf(strObjs[i]);
            ListNode temp = new ListNode(val);
            cur.next = temp;
            cur = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = LinkedListClass.ArrayToList("1,2,3");
        System.out.println(node);
    }
}

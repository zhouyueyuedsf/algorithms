package company.sina;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class ListNode {
    public int val;
    public ListNode next = null;
    public int weight;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Main3 {


    public static void helper(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode node1 = head;
        ListNode node2 = head;
        while (node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        ListNode preMidNode = node1;
        ListNode preCurNode = node1.next;
        while (preCurNode.next != null) {
            ListNode current = preCurNode.next;
            preCurNode.next = current.next;
            current.next = preMidNode.next;
            preMidNode.next = current;
        }

        node1 = head;
        node2 = preMidNode.next;
        while (node1 != preMidNode) {
            preMidNode.next = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node1 = node2.next;
            node2 = preMidNode.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String v = scanner.nextLine();

        ListNode node = new ListNode(Integer.valueOf(v));
        ListNode head = node;

        List<Integer> ns = new ArrayList<>();
        do {
            v = scanner.nextLine();
            if (v.equals("")) {
                break;
            }
            node.next = new ListNode(Integer.valueOf(v));
            node = node.next;
        } while (true);

        helper(head);
        while (head != null) {
            System.out.println("node = " + head.val);
            head = head.next;
        }
    }
}

package niuke.linklist;

import common.ListNode;

public class 两个链表的第一个公共结点 {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null){
			return null;
		}

		ListNode cur = pHead1;
		int pHead1Len = 0;
		int pHead2Len = 0;
		while (cur != null){
			cur = cur.next;
			pHead1Len++;
		}
		cur = pHead2;
		while (cur != null){
			cur = cur.next;
			pHead2Len++;
		}

		int delta = Math.abs(pHead1Len - pHead2Len);
		ListNode temp;
		if (pHead1Len > pHead2Len){
			cur = pHead1;
			temp = pHead2;
		}else {
			cur = pHead2;
			temp = pHead1;
		}

		while (delta-- > 0) {
			cur = cur.next;
		}

		while (cur != temp){
			cur = cur.next;
			temp = temp.next;
		}

		return cur;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		 node1.next = node2;
		 node2.next = node3;
		 node3.next = node4;
		 node4.next = node5;
		 node5.next = node6;
		两个链表的第一个公共结点 run = new 两个链表的第一个公共结点();
		System.out.println(run.FindFirstCommonNode(node1, null).val);

	}
}

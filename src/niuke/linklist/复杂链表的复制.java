package niuke.linklist;

import common.RandomListNode;

/**
 *
 * 
 * @author zhouyueyue1
 *
 */
public class 复杂链表的复制 {

	public RandomListNode copyRandomList(RandomListNode pHead) {
		if (pHead == null)
			return null;
		RandomListNode pCur = pHead;

		while (pCur != null) {
			RandomListNode node = new RandomListNode(pCur.label);
			node.next = pCur.next;
			pCur.next = node;
			pCur = node.next;
		}
		pCur = pHead;

		while (pCur != null) {
			if (pCur.random != null)
				pCur.next.random = pCur.random.next;
			pCur = pCur.next.next;
		}
		RandomListNode head = pHead.next;
		RandomListNode cur = head;
		pCur = pHead;
		while (pCur != null) {
			pCur.next = pCur.next.next;
			if (cur.next != null)
				cur.next = cur.next.next;
			cur = cur.next;
			pCur = pCur.next;
		}
		return head;
	}

	/**
	 * @param pHead
	 * @return
	 */
	public RandomListNode Clone(RandomListNode pHead) {
		RandomListNode curNode = pHead;
		while (curNode != null) {
			RandomListNode newNode = new RandomListNode(curNode.label);
			newNode.next = curNode.next;
			curNode.next = newNode;
			curNode = newNode.next;
		}
		curNode = pHead;
		while (curNode != null && curNode.next != null && curNode.random != null) {
			curNode.next.random = curNode.random.next;
			curNode = curNode.next.next;
		}
		curNode = pHead;
		int count = 0;

		RandomListNode nullHeadNode = new RandomListNode(0);
		RandomListNode bufferNode = nullHeadNode;
		while (curNode != null) {
			if (count % 2 != 0) {
				bufferNode.next = curNode;
				bufferNode = curNode;
			}
			curNode = curNode.next;
			count++;
		}

		return nullHeadNode.next;
	}

	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		RandomListNode node6 = new RandomListNode(6);

		// node1.next = node2;
		node1.random = node1;
		// node2.next = node3;
		// node2.random = node1;
		// node3.next = node4;
		// node3.random = node2;
		// node4.next = node5;
		// node4.random = node3;
		// node5.next = node6;
		复杂链表的复制 run = new 复杂链表的复制();
		run.Clone(node1);
		run.copyRandomList(node1);
	}
}

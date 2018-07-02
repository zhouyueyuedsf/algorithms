package niuke;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class 栈的压入弹出序列 {

	public int push(ArrayList<Integer> stackPushA, int pushAIndex, int popValue) {
		for (int i = pushAIndex; i < stackPushA.size(); i++) {
			if (stackPushA.get(i) == popValue) {
				stackPushA.remove(i);
				return i;
			}
		}
		return -1;
	}
	/**
	 * 有更简洁的方法
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length != popA.length) {
			return false;
		}
		ArrayList<Integer> stackPushA = new ArrayList<>();
		for (int i = 0; i < pushA.length; i++) {
			stackPushA.add(pushA[i]);
		}

		int k = -1;
		for (int i = 0; i < popA.length; i++) {
			int popValue = popA[i];
			if (k > stackPushA.size() - 1) {
				return false;
			}
			if (k >= 0) {
				if (stackPushA.get(k) == popValue) {
					stackPushA.remove(k);
					k = k - 1;
					continue;
				} else {
					k = push(stackPushA, k, popValue);
				}
			} else {
				k = push(stackPushA, 0, popValue);
			}
			if (k < 0) {
				return false;
			}
			k--;
		}
		return true;
	}

	public static void main(String[] args) {
		栈的压入弹出序列 run = new 栈的压入弹出序列();
//		int[] pushA = { 1 };
//		int[] popA = { 1 };
//		boolean b = run.IsPopOrder(pushA, popA);
//		System.out.println(b);
		
		LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
		try {
			blockingQueue.put(1);
			blockingQueue.put(2);
			blockingQueue.put(3);
			blockingQueue.put(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Integer i : blockingQueue) {
			System.out.println(i);
		}
	}
}

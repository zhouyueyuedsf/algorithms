package niuke.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * �е㶫��
 * @author zhouyueyue1
 *
 */
public class 字符串的排列 {
	ArrayList<String> resList = new ArrayList<>();

	public void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}

	public void helper(char[] charArray, int len, int swapIndex) {
		if (swapIndex >= len - 1) {
			resList.add(String.valueOf(charArray));
			return;
		}
		for (int i = swapIndex; i < len; i++) {
			if (i != swapIndex && charArray[i] == charArray[swapIndex]) {
				continue;
			}
			//Arrays.sort(charArray, swapIndex, len);
			swap(charArray, swapIndex, i);
			helper(charArray, len, swapIndex + 1);
			swap(charArray, swapIndex, i);
		}
		return;
	}

	
	public ArrayList<String> Permutation(String str) {
		if(str != null && str.length() > 0) {
			helper(str.toCharArray(), str.length(), 0);
			Collections.sort(resList);
		}
		return resList;
	}

	public static void main(String[] args) {
		字符串的排列 run = new 字符串的排列();
//		char[] charArray = {'c', 'b', 'a'};
//		Arrays.sort(charArray, 1, 3);
		System.out.println(run.Permutation("abc").toString());
	}
}

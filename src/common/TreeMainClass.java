package common;

import leetcode.PathSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeMainClass {

	public static common.TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}
		
		String[] parts = input.split(",");
		String item = parts[0];
		common.TreeNode root = new common.TreeNode(Integer.parseInt(item));
		Queue<common.TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			common.TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new common.TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new common.TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static common.kotlin.Node stringToNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		common.kotlin.Node root = new common.kotlin.Node(Integer.parseInt(item));
		Queue<common.kotlin.Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			common.kotlin.Node node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.setLeft(new common.kotlin.Node(leftNumber));
				nodeQueue.add(node.getLeft());
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.setRight(new common.kotlin.Node(rightNumber));
				nodeQueue.add(node.getRight());
			}
		}
		return root;
	}

	public static String integerArrayListToString(List<Integer> nums, int length) {
		if (length == 0) {
			return "[]";
		}

		String result = "";
		for (int index = 0; index < length; index++) {
			Integer number = nums.get(index);
			result += Integer.toString(number) + ", ";
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static String integerArrayListToString(List<Integer> nums) {
		return integerArrayListToString(nums, nums.size());
	}

	public static String int2dListToString(List<List<Integer>> nums) {
		StringBuilder sb = new StringBuilder("[");
		for (List<Integer> list : nums) {
			sb.append(integerArrayListToString(list));
			sb.append(",");
		}

		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			TreeNode root = stringToTreeNode(line);
			line = in.readLine();
			int sum = Integer.parseInt(line);
			
			
			List<List<Integer>> ret = new PathSum().pathSum(root, sum);

			String out = int2dListToString(ret);

			System.out.print(out);
		}
	}

}

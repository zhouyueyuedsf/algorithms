package niuke.tree;

import common.TreeNode;
import java.util.ArrayList;
public class 二叉树中和为某一值的路径 {
	ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

	ArrayList<Integer> path = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if(root == null) return paths;
		target = target - root.val;
		path.add(root.val);
		if(root.left == null && root.right == null && target == 0) {
			paths.add(new ArrayList<>(path));
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		path.remove(path.size() - 1);
		return paths;
	}
}

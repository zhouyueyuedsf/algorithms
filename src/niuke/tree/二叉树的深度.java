package niuke.tree;

import common.TreeMainClass;
import common.TreeNode;

public class 二叉树的深度 {


    int maxDepth = Integer.MIN_VALUE;

    public int TreeDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curDepth) {
        if (root == null) {
            return curDepth;
        }
        curDepth++;
        return maxDepth = Math.max(maxDepth, Math.max(helper(root.left, curDepth), helper(root.right, curDepth)));
    }


    public static void main(String[] args) {
        TreeNode node = TreeMainClass.stringToTreeNode("[1,2,3,4,5,6,7,8]");
        二叉树的深度 run = new 二叉树的深度();
        System.out.println(run.TreeDepth(node));
    }


}

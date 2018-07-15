package niuke.tree;

import common.TreeMainClass;
import common.TreeNode;

public class 平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root != null) {
            int d = Math.abs(helper(root.left, 0) - helper(root.right, 0));
            return d <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        return true;
    }

    private int helper(TreeNode root, int curHeight) {
        if (root == null) {
            return curHeight;
        }
        curHeight++;
        return Math.max(helper(root.left, curHeight), helper(root.right, curHeight));
    }

    /**
     * 测试用单递归检测
     * @param root
     * @return
     */
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ll = helper(root.left);
        if (ll == -1) return -1;
        int rl = helper(root.right);
        if (rl == -1) return -1;
        return Math.abs(ll - rl) > 1 ? -1 : 1 + Math.max(ll, rl);
    }

    public boolean IsBalanced_Solution2(TreeNode treeNode){
        return helper(treeNode) != -1;
    }



    public static void main(String[] args) {
        TreeNode node = TreeMainClass.stringToTreeNode("[1,null,2,null,3,null,4,null,5]");
        平衡二叉树 run = new 平衡二叉树();
        System.out.println(run.helper(node));
    }


}

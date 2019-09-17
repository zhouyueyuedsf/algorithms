package leetcode.tree;

import common.TreeMainClass;
import common.TreeNode;

public class _236 {
    private TreeNode res = null;

    /**
     * 一个较优秀的方案
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int helper(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return 0;
        }
        int mid = (root == p || root == q) ? 1 : 0;
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);
        if(this.res != null) {
            return -1;
        }
        if(left + right + mid >= 2) {
            this.res = root;
        }
        return left + right + mid;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeMainClass.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        _236 run = new _236();
        run.lowestCommonAncestor(root, root.right.left, root.right.right);
    }
}

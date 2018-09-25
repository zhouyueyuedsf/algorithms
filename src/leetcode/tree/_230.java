package leetcode.tree;

import common.TreeMainClass;
import common.TreeNode;

public class _230 {

    public static int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            int val = kthSmallest(root.left, k);
            return val;
        } else if(k > count + 1) {
            int val = kthSmallest(root.right, k - count - 1);
            return val;
        }
        return root.val;
    }

    public static int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /**
     * [3,1,4,null,2]
     1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(kthSmallest(TreeMainClass.stringToTreeNode("[3,1,4,null,2]"), 2));
    }
}

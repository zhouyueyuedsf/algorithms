package niuke.tree;

import common.TreeNode;

public class 二叉搜索树的最长路径 {

    int max = 0;
    //放到maxLenth里去循环是因为有个当为null的时候是0，为一个的时候也是0
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxLenth(root);
        return max;
    }
    public int maxLenth(TreeNode root){
        if(root == null) return 0;
        int leftLen = maxLenth(root.left);
        int rightLen = maxLenth(root.right);
        max = Math.max(max, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }

}

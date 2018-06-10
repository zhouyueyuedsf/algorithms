package tree;

import tree.子树.TreeNode;

/**
 * 求一个树的二叉树的镜像
 * @author zhouyueyue1
 *
 */
public class 二叉树的镜像 {
	public void Mirror(TreeNode root) {
        if(root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

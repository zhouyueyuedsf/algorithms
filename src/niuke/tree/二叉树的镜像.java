package niuke.tree;

import common.TreeNode;

/**
 * ��һ�����Ķ������ľ���
 * @author zhouyueyue1
 *
 */
public class �������ľ��� {
	public void Mirror(TreeNode root) {
        if(root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

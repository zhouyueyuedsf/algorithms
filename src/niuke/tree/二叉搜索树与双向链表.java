package niuke.tree;

import common.TreeMainClass;
import common.TreeNode;

public class 二叉搜索树与双向链表 {

	TreeNode lastNode = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) {
			return null;
		}
		ConvertNode(pRootOfTree);
		while(pRootOfTree.left != null) {
			pRootOfTree = pRootOfTree.left;
		}
		return pRootOfTree;
	}

	private void ConvertNode(TreeNode pRootOfTree) {
		// TODO Auto-generated method stub
		if (pRootOfTree == null) {
			return;
		}
		ConvertNode(pRootOfTree.left);
		if(lastNode != null)lastNode.right = pRootOfTree;
		if(pRootOfTree != null) pRootOfTree.left = lastNode;
		lastNode = pRootOfTree;
		ConvertNode(pRootOfTree.right);
	}

	public static void main(String[] args) {
		TreeNode node = TreeMainClass.stringToTreeNode("[1,2,3]");
		二叉搜索树与双向链表 run = new 二叉搜索树与双向链表();
		TreeNode tn = run.Convert(node);
		
	}

	


}
 
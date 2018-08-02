package niuke.tree;

import common.TreeMainClass;
import common.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 *
 * 难点：
 * 思维：利用lastNode节点进行记录中序遍历访问的节点顺序
 */
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
 
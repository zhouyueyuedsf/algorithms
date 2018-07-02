package niuke.tree;

import common.Solution;
import common.TreeMainClass;
import common.TreeNode;

public class ������������˫������ {

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
		TreeNode node = TreeMainClass.stringToTreeNode("");
		������������˫������ run = new ������������˫������();
		TreeNode tn = run.Convert(node);
		
	}

	


}
 
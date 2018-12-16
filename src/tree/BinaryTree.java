package tree;

import common.TreeNode;

public class BinaryTree {
    /**
     * 非递归遍历二叉树
     */

    //TODO 前序
    public void preOrderUnRecur(TreeNode node) {

    }

    //TODO 中序
    public void inOrderUnRecur(TreeNode node) {

    }

    //TODO 后序
    public void posOrderUnRecur(TreeNode node) {

    }

    /**
     * 得到树的高度
     * @param node
     * @return
     */
    public static int getHeight(TreeNode node){
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
    /**
     * 打印二叉树的边界节点
     * 边界节点：1.在所属层的最左或者最右 2.头结点 3.叶节点
     *
     * 层次遍历加标记解决
     * @param node
     */
    public static void printEdge(TreeNode node){

    }

    /**
     * 在二叉树中找到累加和为指定值的最长路径长度
     * @param node
     */
    public static void maxPathLen(TreeNode node){

    }


}

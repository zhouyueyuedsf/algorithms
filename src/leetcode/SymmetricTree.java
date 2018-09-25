package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouyueyue1
 *
 */
public class SymmetricTree {
	 List<Integer> intListLeft = new ArrayList<>();
	    public void helperLeft(TreeNode root){
	        if(root == null) {
	            intListLeft.add(Integer.MIN_VALUE);
	            return;   
	        } 
	        intListLeft.add(root.val);
	        helperLeft(root.left);
	        helperLeft(root.right);
	    }
	    List<Integer> intListRight = new ArrayList<>();
	    public void helperRight(TreeNode root){
	         if(root == null) {
	            intListRight.add(Integer.MIN_VALUE);
	            return;   
	        } 
	        intListRight.add(root.val);
	        helperRight(root.right);
	        helperRight(root.left);
	    }
	    
	    //�ݹ鷽�� write by zhouyueyue
	    public boolean isSymmetric(TreeNode root) {
	        helperLeft(root);
	        helperRight(root);
	        int leftSize = intListLeft.size();
	        int rightSize = intListRight.size();
	        if(leftSize != rightSize) return false;
	        for(int i = 0; i < intListLeft.size(); i++){
	            int left = intListLeft.get(i);
	            int right = intListRight.get(i);
	            if(left != right) return false;
	        }
	        return true;
	    }
	    
	    //�Ż�����
	    public boolean isSymmetricForOffical(TreeNode p, TreeNode q) {
	    	if(p == null && q == null) return true;
	    	if(p == null || q == null) return false;
	    	return p.val == q.val && isSymmetricForOffical(p.left, q.right) 
	    			&& isSymmetricForOffical(p.right, q.left);
	    }
	    public boolean isSymmetricForOffical(TreeNode root) {
	    	
	    	return true;
	    }
}

package tree;

public class ×ÓÊ÷ {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	 boolean checked = true;;
	    public boolean check(TreeNode root1, TreeNode root2){
	        if(!checked) return checked;
	        if(root1 == null || root2 == null) return checked;
	        
	        if(root1.val == root2.val){
	            return check(root1.left, root2.left) && check(root1.right, root2.right);
	        }else{
	            checked = false;
	            return checked;
	        }
	    }
	    
	    boolean hasSubTree = false;
	    
	    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	        if(hasSubTree) return hasSubTree;
	        if(root1 == null && root2 == null) return hasSubTree;
	        if(root1.val == root2.val && check(root1, root2)){
	            hasSubTree = true;
	            return hasSubTree;
	        };
	        return HasSubtree(root1.left, root2) && HasSubtree(root1.right, root2);
	        
	    }
	    
	   public static void main(String[] args) {
		   System.out.println(isLowVersion("3.1", null));
	}

	private static boolean isLowVersion(String divideVersionStr, String curVerisonStr) {
		  if(curVerisonStr == null){
	            return false;
	        }
		String[] divideVersionNumbers = divideVersionStr.split("\\.");
	   String[] curVersionNumbers = curVerisonStr.split("\\.");
	   
	   for(int i = 0; i < divideVersionNumbers.length; i++) {
		   try {
			   int divideVersionNumber = Integer.parseInt(divideVersionNumbers[i]);
			   if(i < curVersionNumbers.length) {
				   int curVersionNumber = Integer.parseInt(curVersionNumbers[i]);
				   if(curVersionNumber < divideVersionNumber) {
					   return true;
				   }else if(curVersionNumber > divideVersionNumber){
					   return false;
				   }
			   }else {
				   return true;
			   }
			} catch (Exception e) {
				// TODO: handle exception
			}
	   }
	   return !(curVersionNumbers.length > divideVersionNumbers.length);
	}
}

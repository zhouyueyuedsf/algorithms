package tree;


 //Definition for a binary tree node.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    List<List<Integer>> lists= new LinkedList<>();
    public int helper(TreeNode root, int sum, int curSum, List<Integer> list){
    	 LinkedList<Integer> next = new LinkedList<>(list);
         if(root == null) {
              return curSum;
         };
         int mid = root.val;
         next.add(mid);
         curSum += mid;
         
//         if(curSum > sum) {
//             return curSum - next.removeLast();
//         }
//         
         if(curSum == sum && root.left == null && root.right == null) {
             lists.add(new LinkedList<>(next));
             return curSum - next.removeLast();
         };
         
      
         
         int left = helper(root.left, sum, curSum, next);
         
         int right = helper(root.right, sum, left, next);
         
         return curSum - next.removeLast();
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, 0, new LinkedList<>());
        return lists;
    }
}

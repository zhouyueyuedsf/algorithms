package niuke;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	       ArrayList<Integer> intList = new ArrayList<Integer>();
	        int level = 0;
	        int i = 0;
	        int j = 0;
	        int height = matrix.length;
	        if(height <= 0){
	        	return intList;
	        }
	        int width = matrix[0].length;
	        
	        int max_top = 0;
	        int max_bottom = height - 1;
	        int max_left = 0;
	        int max_right = width - 1;
	        //int orginLevel = -1;
	        if(width > 0 || height > 0) {
	        	 for(;;){
	 	            if(i > max_bottom && i < max_top && j > max_right && j < max_left ){
	 	               break;
	 	           }
	 	           int orginLevel = level;
	 	           if(i > max_bottom || i < max_top || j > max_right || j < max_left ){
	 	               level = (level + 1) % 4;//���ȼ��仯,��ʼ���Ϊ�ң��£�����
	 	           }
	 	           if(orginLevel == level) {
	 	        	   intList.add(matrix[i][j]);
	 	           }
	 	           //��
	 	           if(level == 0){
	 	               j++;
	 	               if(orginLevel != level){
	 	            	   max_left++;
	 	            	   i++;
	 	               }
	 	           } else if(level == 1){
	 	               i++;
	 	               if(orginLevel != level){
	 	            	   max_top++;
	 	            	   j--;
	 	               }
	 	           } else if(level == 2){
	 	               j--;
	 	               if(orginLevel != level){
	 	            	   max_right--;
	 	            	   i--;
	 	               }
	 	           } else if(level == 3){
	 	               i--;
	 	               if(orginLevel != level){
	 	            	   max_bottom--;
	 	            	   j++;
	 	               }
	 	           }
	 	           
	 	       }
	        }
	       return intList;
	    }
	
	public static void main(String[] args) {
		顺时针打印矩阵 t = new 顺时针打印矩阵();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{10,11,12,13},{14,15,16,17}};
		System.out.println(t.printMatrix(matrix));
	}
}

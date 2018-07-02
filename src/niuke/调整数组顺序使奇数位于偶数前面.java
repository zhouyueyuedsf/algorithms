package niuke;

import java.util.*;

public class 调整数组顺序使奇数位于偶数前面 {
	public static void reOrderArray(int [] array) {
        LinkedList<Integer> listArray = new LinkedList<Integer>();
        listArray.size();
        if(array.length > 0) listArray.add(array[0]);
        for(int i = 1; i < array.length; i++){
            int a = array[i];
            int index = i;
            boolean bool = false;
            for(int j = listArray.size() - 1; j >=0; j-- ){
                int b = listArray.get(j);
                if(!(a % 2 != 0 && b % 2 == 0)){
                     listArray.add(j + 1, a);
                     bool = true;
                     break;
                }
            }
            if(!bool){
                listArray.add(0, a);
            }
        }
        for(int i = 0; i < listArray.size(); i++){
            array[i] = listArray.get(i);
        }
    }
	
	public static void main(String[] args) {
		int array[] = {};
		调整数组顺序使奇数位于偶数前面.reOrderArray(array);
		System.out.println(array);
		
		Integer[] ins = {};
		
		ins[0] = 1;
		
		int i = 0 ;
	}
}

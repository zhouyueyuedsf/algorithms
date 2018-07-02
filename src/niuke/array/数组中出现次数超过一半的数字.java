package niuke.array;

/**
 *
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class 数组中出现次数超过一半的数字 {

   //超过一半的数字，则必定有两个连续的3,3,3,3,2,2,2,2,2
    public int MoreThanHalfNum_Solution(int [] array) {
//        int A[] = new int[array.length];
        int more = 0;
        int value;
        for (int i = 1; i < array.length; i++){
            if (array[i - 1] == array[i]){
                value = array[i];
                more++;
            } else {
                more = more - 1 < 0 ? 0 : more - 1;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        数组中出现次数超过一半的数字 run = new 数组中出现次数超过一半的数字();

    }
}

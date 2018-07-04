package niuke.array;

/**
 *
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class 数组中出现次数超过一半的数字 {


    public int MoreThanHalfNum_Solution(int [] array) {
        return 0;
    }

    /**
     * 快速排序
     * @return
     */
    public int quickSort(){
        return 0;
    }

    /**
     * 分形叶思想
     * @return
     */
    private int helper(int[] array){
        if(array == null) return 0;
        int len = array.length;

        if(len < 1) {
            return 0;
        }

        int result = array[0];
        int time = 0;
        for (int i = 1; i < len; i++){
            if(time == 0) {
                result = array[i];
                time = 1;
            } else {
                if(result == array[i]){
                    time++;
                } else {
                    time--;
                }
            }
        }
        time = 0;
        for(int i = 0; i < len; i++){
            if(result == array[i]){
                time++;
            }
        }

        if(time*2 <= len){
            result=0;
        }
        return result;
    }


    public static void main(String[] args) {
        数组中出现次数超过一半的数字 run = new 数组中出现次数超过一半的数字();
        int[] array = {1,2};

        System.out.println( run.helper(array));
    }
}

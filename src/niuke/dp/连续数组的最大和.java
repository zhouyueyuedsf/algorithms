package niuke.dp;

public class 连续数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return Integer.MIN_VALUE;
        }
        int max = array[0];
        //指定到达某点的最大值
        int sum = array[0];

        for(int i = 1; i < array.length; i++){
            sum = Math.max(sum + array[i], array[i]);
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        连续数组的最大和 run = new 连续数组的最大和();
        System.out.println( run.FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 12, 2}));

    }
}

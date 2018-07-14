package niuke.array;

public class 数字在排序数组中出现的次数 {

    public int GetNumberOfK(int [] array , int k) {
        int res = 0;
        for (int a : array){
            if(a == k){
                res++;
            }
        }
        return res;
    }

    /**
     * 二分法 找到第一个k 和最后一个k。两者相减
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfKInBinary(int[] array, int k){
        int res = 0;

        return res;
    }

    public static void main(String[] args) {
        数字在排序数组中出现的次数 run = new 数字在排序数组中出现的次数();
        System.out.println(run.GetNumberOfK(new int[]{1,2,2,2,2,2,3,3,3,3,4,5}, 3));

    }
}

package company.bytedance.two;


import java.util.Scanner;

/**
 * 超时与oom混合的题
 * 较好思路：https://blog.csdn.net/u010698086/article/details/79679340
 */
public class Main2 {

    /**
     * 返回最小值的索引
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int minRange(int[] arr, int start, int end){
        int min = Integer.MAX_VALUE;
        int index = start;
        for (int i = start; i < end + 1; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int sumRange(int[] arr, int start, int end){
        int sum = 0;
        for (int i = start; i < end + 1; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int quickSum(int[] arr, int start, int end, int sum, int len){
        if (end - start > len / 2) {
            for (int i = start - 1; i >= 0; i--) {
                sum -= arr[i];
            }
            for (int i = end + 1; i < len; i++) {
                sum -= arr[i];
            }
        } else {
            return sumRange(arr, start, end);
        }
        return sum;
    }

    public static void applyRange(int[] arr, int end, int[] res){
        for (int i = 0; i < end + 1; i++) {
            if (i == 0) {
                res[i] = arr[i];
            } else {
                res[i] = arr[i] + res[i - 1];
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        if (num <= 0) {
            System.out.println(0);
            return;
        }
        int[] v = new int[num];

        for (int i = 0; i < num; i++) {
            v[i] = scanner.nextInt();
        }

        int minIndex = minRange(v, 0, num - 1);

        int sum = sumRange(v, 0, num - 1);
//        applyRange(v, num - 1, sumR);

        //l-r的最小值
//        int[][] minLR = new int[num][num];
        //l-r总和
//        int[][] sumLR = new int[num][num];
        //l-r的minLR * sumLR的最大值

        int[][] F = new int[num][num];



        int min = v[minIndex];
        //对角线遍历数组思想
        for (int k = 0; k < num; k++) {
            for (int l = 0; l < num - k; l++) {
                int r = k + l;
                if (l < r) {
                    if (minIndex > l && minIndex < r) {
                        min = v[minIndex];
                    } else {
                        //更新minIndex
                        minIndex = minRange(v, l, r);
                        min = v[minIndex];
                    }
                    int y = min * quickSum(v, l, r, sum, num);
                    F[l][r] = Math.max(Math.max(F[l][r - 1], F[l + 1][r]), y);

//                    minLR[l][r] = Math.min(v[r], minLR[l][r - 1]);
//                    sumLR[l][r] = sumLR[l][r - 1] + v[r];
                } else {
                    F[l][r] = v[l] * v[r];
//                    minLR[l][r] = v[l];
//                    sumLR[l][r] = v[l];
                }
            }
        }

        System.out.println(F[0][num - 1]);
    }
}

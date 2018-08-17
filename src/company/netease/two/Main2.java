package company.netease.two;

import java.util.*;

/**
 * 超时算法
 * 较好食思路:https://fengxc.me/2018网易笔试题及解答-Java.html#more
 */
public class Main2 {
    public static int sumRange(int[] arr, int start, int end, int[] isAlive, boolean isCalZero) {
        int sum0 = 0;
        int sum1 = 0;
        for (int i = start; i < end + 1; i++) {
            if (isAlive[i] == 0) {
                sum0 += arr[i];
            } else {
                sum1 += arr[i];
            }
        }

        return isCalZero ? sum0 + sum1 : sum1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();

        int[] scores = new int[num];
        int[] isAlive = new int[num];
        for (int i = 0; i < num; i++) {
            scores[i] = scanner.nextInt();
        }
        List<Integer> zeroIndex = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            isAlive[i] = scanner.nextInt();
            if (isAlive[i] == 0) {
                zeroIndex.add(i);
            }
        }

        int preSum = 0;
        int maxSum = 0;
        int rangeOneSum = 0;
        for (int i = 0; i < zeroIndex.size(); i++) {
            int rangeTwoSum = 0, rangeThreeSum = 0;
            if (i > 0) {
                int l = zeroIndex.get(i);
                int lPre = zeroIndex.get(i - 1);
                if (l > 0) {
                    rangeOneSum = rangeOneSum + sumRange(scores, lPre + 1, l - 1, isAlive, false);
                }

                rangeTwoSum = sumRange(scores, l, l + k < num ? l + k - 1 : num - 1, isAlive, true);
                if (l + k + 1 < num) {
                    rangeThreeSum = sumRange(scores, l + k , num - 1, isAlive, false);
                } else {
                    rangeThreeSum = 0;
                }
                maxSum = Math.max(maxSum, rangeOneSum + rangeTwoSum + rangeThreeSum);
            } else {
                int l = zeroIndex.get(i);
                if (l > 0) {
                    rangeOneSum = sumRange(scores, 0, l - 1, isAlive, false);
                }
                rangeTwoSum = sumRange(scores, l, l + k < num ? l + k - 1 : num - 1, isAlive, true);
                if (l + k + 1 < num) {
                    rangeThreeSum = sumRange(scores, l + k, num - 1, isAlive, false);
                }
                maxSum = rangeOneSum + rangeTwoSum + rangeThreeSum;
            }
        }


        System.out.println(maxSum);

    }
}

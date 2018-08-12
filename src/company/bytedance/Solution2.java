package company.bytedance;

import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {

    static int n;
    static int x[];
    static int y[];
    static HashMap<Integer, Integer> recordMap[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        x = new int[n];
        y = new int[n];
        recordMap = new HashMap[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            recordMap[i] = new HashMap<>();
        }
        int a = 0, b = 0;
        int d = 0;
        System.out.println(dp(0 , d));
    }

    private static int dp(int i, int d) {

        if (recordMap[i].get(d) != null) {
            return recordMap[i].get(d);
        }

        // 最后一个张牌
        if (i == n - 1) {
            if (d + x[i] != 0 && d - x[i] != 0) {
                if (d == 0) { // 不抽取
                    return 0;
                }
                return Integer.MIN_VALUE;
            } else {
                return y[i];
            }
        }
        // 抽取当前这张牌
        // a 抽
        int temp1 = y[i] + dp(i + 1,d + x[i]);
        // b 抽
        int temp2 = y[i] + dp(i + 1,d - x[i]);

        // 不抽取当前这张牌
        int temp3 = dp(i + 1, d);

        int max;
        max = temp1 > temp2 ? temp1 : temp2;
        max = max > temp3 ? max : temp3;

        recordMap[i].put(d, max);

        return max;
    }
}
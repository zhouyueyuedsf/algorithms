package company.meituan.one;

import java.util.Scanner;

/**
 * 1,5,10,20,50,100组成指定面额的总类
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() + 1;
        int[] V = new int[]{1, 5, 10, 20, 50, 100};
        //F[n][m],n代表总面额值，m为V的索引，即表示n元的面值，用最大值<=V[m]的面额去表示的组合数
        long[][] DP = new long[n][V.length];
        //dp的初始化值
        for (int i = 0; i < n; i++) {
            DP[i][0] = 1;
        }
        for (int j = 0; j < V.length; j++) {
            DP[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < V.length; j++) {
                if (i > V[j]) {
                    DP[i][j] = DP[i - V[j]][j] + DP[i][j - 1];
                } else if (i == V[j]){
                    DP[i][j] = DP[i][j - 1] + 1;
                }else {
                    DP[i][j] = DP[i][j - 1];
                }
            }
        }
        System.out.println(DP[n - 1][5]);
    }
}

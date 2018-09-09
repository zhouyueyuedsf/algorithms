package company.ali.two;

import java.util.Scanner;

/**
 * 火柴组成的数
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int m;
        m = Integer.parseInt(in.nextLine().trim());
        int n;
        n = Integer.parseInt(in.nextLine().trim());



        res = maxNum(m, n);
        System.out.println(res);
    }

    private static String maxNum(int m, int n) {

        int[][] bags= new int[2][9];
        bags = new int[][]{ {1, 2},{2, 5},{3,5},{4,4}, {5, 5}, {6, 6},{7, 3}, {8, 7}, {9, 6} };
        long[][] F = new long[m][n];
        for (int i = 2; i < m; i++) {
            F[i][1] = 1;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 2; j < n; j++) {
                long max = Integer.MIN_VALUE;
                int index = 0;
                for (int k = index; k < 9; k++) {
                    if (i > bags[k][1]) {
                        if (max < F[i - bags[k][1]][j - 1]) {
                            max = F[i - bags[k][1]][j - 1];
                            index = k;
                        }
                    } else {
                        break;
                    }
                }
                F[i][j] = Math.max(F[i - bags[index][1]][j - 1] + (long)(index * Math.pow(10, index)), F[i][j]);
            }
        }
        return String.valueOf(F[m - 1][n - 1]);
    }
}
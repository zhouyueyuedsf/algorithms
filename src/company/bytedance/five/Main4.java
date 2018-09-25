package company.bytedance.five;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        System.out.println(count(n, m, k));
    }

    static final int max = 30;

    static long F[][][][] = new long[max][max][max][3];

    static long helper(int n, int m, int k, int last) {
        if (n < 0 || m < 0 || k < 0)
            return 0;

        if (n == 1 && m == 0 && k == 0 && last == 0)
            return 1;

        if (n == 0 && m == 1 && k == 0 && last == 1)
            return 1;

        if (n == 0 && m == 0 && k == 1 && last == 2)
            return 1;

        if (F[n][m][k][last] != -1)
            return F[n][m][k][last];

        if (last == 0)
            F[n][m][k][last] = helper(n - 1, m, k, 1) +
                    helper(n - 1, m, k, 2);

        else if (last == 1)
            F[n][m][k][last] = helper(n, m - 1, k, 0) +
                    helper(n, m - 1, k, 2);
        else
            F[n][m][k][last] = helper(n, m, k - 1, 0) +
                    helper(n, m, k - 1, 1);

        return F[n][m][k][last];
    }

    // Returns count of required arrangements
    static long count(int p, int q, int r) {
        // Initialize 'dp' array
        for (long[][][] row : F) {
            for (long[][] innerRow : row) {
                for (long[] innerInnerRow : innerRow) {
                    Arrays.fill(innerInnerRow, -1);
                }
            }
        }
        ;

        return helper(p, q, r, 0) +
                helper(p, q, r, 1) +
                helper(p, q, r, 2);
    }

}
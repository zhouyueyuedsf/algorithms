package company.bytedance;

import java.util.Scanner;

public class Solution {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());

        String nums1 = scanner.nextLine();
        String nums2 = scanner.nextLine();
        String[] s1 = nums1.split(" ");
        String[] s2 = nums2.split(" ");
        int[] a = new int[num];
        int[] b = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = Integer.valueOf(s1[i]);
            b[i] = Integer.valueOf(s2[i]);
        }

        int[][] F = new int[num][num];

        for (int i = 0; i < num; i++) {
            if (a[i] < b[i]) {
                F[i][i] = 1;
            } else {
                F[i][i] = 0;
            }
        }
        int j = 1;

        int row = 0;
        int col = 0;
        int maxA = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;
        for (int i = 1; i <= num - 1; i++) {
            row = 0;
            col = i;
            while (row >= 0 && row < num && col >= 0 && col < num) {
                F[row][col] = F[row][col - 1] + F[row + 1][col];

                for (int k = row; k <= col; k++) {
                    if (a[k] > maxA) {
                        maxA = a[k];
                    }
                    if (b[k] < minB) {
                        minB = b[k];
                    }
                }

                if (maxA < minB) {
                    F[row][col]++;
                }

                if (row > 0 && F[row][col - 1] > 0) {
                    F[row][col]--;
                }
                row++;
                col++;
                maxA = Integer.MIN_VALUE;
                minB = Integer.MAX_VALUE;
            }

        }
        System.out.println(F[row-1][col-1]);
    }
}

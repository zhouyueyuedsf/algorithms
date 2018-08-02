package company.pdd;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] str = new String[N];
        for (int i = 0; i < M; i++) {
            str[i] = scanner.next();
        }
        char[][] arr = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = str[i].charAt(j);
            }
        }
        int[] max = new int[M];

        int k = -1;

        for (int i = 0; i < N; i++) {
            int[] temp = new int[M];
            for (int j = 0; j < M; j++) {
                temp[j] = arr[j][i];
            }
            for (int n = 0; n < N; n++){
                if (n != i) {
                    for (int j = 0; j < M; j++) {
                        max[j] = arr[j][n];
                    }
                    k = compare(temp, i, max, k);
                    if (k == -1){
                        break;
                    }
                }
            }
            if (k != -1){
                break;
            }
        }
        System.out.println(k);
    }

    private static int compare(int[] temp, int i, int[] max, int k) {
        int count = 0;
        for (int m = 0; m < temp.length; m++) {
            if (temp[m] < max[m]) {
                count++;
            }
        }
        if (count > temp.length / 2) {

            return i;
        } else {
            return -1;
        }
    }

}


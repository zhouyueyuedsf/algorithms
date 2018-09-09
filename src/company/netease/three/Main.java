package company.netease.three;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int max = 0;
            int min = 0;
            if (k > 0) {
                if (k - 1 > n - k) {
                    max = n - k;
                } else {
                    max = k - 1;
                }
            } else {
                max = 0;
            }
            System.out.println(min + " " + max);
        }
    }
}

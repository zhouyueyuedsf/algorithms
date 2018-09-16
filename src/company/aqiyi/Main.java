package company.aqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String[] s = scanner.nextLine().split(" ");
            int num = Integer.parseInt(s[1]) - 1;
            if (s[0].equals("B")) {
                a[num]--;
            } else {
                a[num]++;
            }
        }
        int pivot = a[p - 1];
        Arrays.sort(a);
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (pivot == a[i]) {
                res = i - n + 2;
                break;
            }
        }

        System.out.println(res);

    }
}

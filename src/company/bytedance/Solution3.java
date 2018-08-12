package company.bytedance;

import java.util.Scanner;

public class Solution3 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }


        int dp_max[] = new int[n];
        int dp_min[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i==j){
                    dp_max[j] = a[i];
                    dp_min[j] = b[i];
                    if (dp_max[j]<dp_min[j]){
                        count++;
                    }
                }else if(i<j){
                    dp_max[j] = Math.max(dp_max[j-1],a[j]);
                    dp_min[j] = Math.min(dp_min[j-1],b[j]);
                    if (dp_max[j]<dp_min[j]){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

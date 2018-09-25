package company.bytedance.five;

import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] arrs = new String[n];
        for (int i = 0; i < n; i++) {
            arrs[i] = in.nextLine();
        }

        helper(n, arrs);
    }

    private static void helper(int n, String[] arrs) {
        for (int i = 0; i < n; i++) {
            String w = arrs[i];
            for (int j = 1; j <= w.length(); j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (i == k) continue;
                    if (arrs[k].length() >= j
                            && arrs[k].substring(0, j).equals(w.substring(0, j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(w.substring(0, j));
                    break;
                }
            }
        }
    }
}
package company.netease;

import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = scanner.nextLine();
        }
        for (String s : strs) {
            String[] s1 = s.split(":");
            Solution.helper(s1);
        }
    }

    private static void helper(String[] s1) {
        String hh = s1[0];
        String mm = s1[1];
        String ss = s1[2];
        StringBuilder builder = new StringBuilder();

        if (Integer.valueOf(hh) < 0 || Integer.valueOf(mm) < 0 || Integer.valueOf(ss) < 0)
            return;
        if (Integer.valueOf(hh) >= 100 || Integer.valueOf(mm) >= 100 || Integer.valueOf(ss) >= 100)
            return;


        int h1 = (int) hh.charAt(0) - '0';
        int h2 = hh.charAt(1) - '0';
        if (h1 > 2) {
            h1 = 0;
        }

        minStr(hh, builder, 2, h1 == 2 ? 3 : 9);
        builder.append(":");
        minStr(mm, builder, 6, 9);
        builder.append(":");
        minStr(ss, builder, 6, 9);
        System.out.println(builder.toString());
    }

    private static void minStr(String hh, StringBuilder builder, int h1Max, int h2Max) {
        int h1 = (int) hh.charAt(0) - '0';
        int h2 = hh.charAt(1) - '0';
        if (h1 > h1Max) {
            h1 = 0;
        }
        if (h2 > h2Max) {
            h2 = 0;
        }
        builder.append(h1).append(h2);
    }
}

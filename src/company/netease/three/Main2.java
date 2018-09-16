package company.netease.three;

import java.util.Scanner;

/**
 * bbw->bwb: bbwbbw
 */
public class Main2 {

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        int len = inputStr.length();
        digui(inputStr, 0, len);
        int count = 0;
        int max = 0;
        boolean isFirst = true;
        for (int i = 0; i < inputStr.length(); i++) {
            if (i + 1 < len) {
                char c1 = inputStr.charAt(i);
                char c2 = inputStr.charAt(i + 1);
                if (isFirst && c1 != c2) {
                    count = count + 2;
                    max = Math.max(max, count);
                    isFirst = false;
                } else if (!isFirst && c1 != c2){
                    count++;
                    max = Math.max(max, count);
                }else {
                    isFirst = true;
                    count = 0;
                }
            }
        }
        System.out.println(max);
    }

    private static void digui(String inputStr, int start ,int len) {

        if (start >= len) {
            return;
        }

        for (int i = start; i < len; i++) {
            if (i + 1 < len) {
                String pre = inputStr.substring(0, i + 1);
                String after = inputStr.substring(i + 1, len);
                if (pre.charAt(0) != after.charAt(after.length() - 1)) {
                    digui(reverse(pre) + reverse(after), i + 1, len);
                }
            }
        }
    }

}

package company.bytedance.five;

import java.util.Scanner;

public class Main5 {

    public static int getChangeNum(long orgNum) {
        long targetNum = orgNum + 1;
        int count = 1;
        while (targetNum != 0 && orgNum != 0) {
            int targetRem = (int) (targetNum % 10);
            targetNum = (long) (targetNum / 10);
            int resRem = (int) (targetNum % 10);
            orgNum = (long) (orgNum / 10);
            if (resRem == targetRem) {
                break;
            }
            count++;
        }
        return count;
    }

    public static boolean isLenChange(long orgNum) {
        long targetNum = orgNum + 1;
        String orgStr = Long.toString(orgNum);
        String targetStr = Long.toString(targetNum);
        return orgStr.length() != targetStr.length();
    }

    private static boolean isLuckyNum(long number) {
        String numberStr = String.valueOf(number);
        numberStr = "0" + numberStr;
        int len = numberStr.length();
        int min = (int) Math.floor((len - 1) / 2);
        for (int i = 1; i <= min; i++) {
            if (numberStr.charAt(i) == numberStr.charAt(len - i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        int res = 0;
        boolean isPreLucky;
        int isPreIndex = 0;
        isPreLucky = isLuckyNum(a);
        if (isPreLucky) {
            res++;
        }
        for (long num = a + 1; num <= b; num++) {
            if (isLenChange(num)) {
                if (isLuckyNum(num)) {
                    isPreLucky = true;
                    res++;
                } else {
                    isPreLucky = false;
                }
            } else {
                int c = getChangeNum(num);
                char[] cs = String.valueOf(num).toCharArray();
                int len = cs.length;
                boolean flag = true;
                int min = (int) Math.floor((len - 1) / 2);
                if (c < min) {
                    min = c;
                }
                for (int j = len - 1; j > len - min; j--) {
                    if (len - 1 - j != j && cs[len - 1 - j] == cs[j]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;
                if (isPreLucky) {
                    res++;
                    isPreLucky = true;
                } else{
                    boolean flag2 = true;
                    for (int k = len - min; k > min; k--) {
                        if (cs[len - 1- k] == cs[k]) {
                            flag2 = false;
                            break;
                        }
                    }
                    if (flag) {
                        res++;
                    }

                }
            }
        }
        System.out.println(res);
    }
}

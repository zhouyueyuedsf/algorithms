package company.bytedance.four;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(constructAddresses(line));
    }

    public static int constructAddresses(String line) {
        ArrayList<String> list = new ArrayList<String>();

        if (line.length() < 4 || line.length() > 12)
            return 0;

        helper(list, line, 0);

        return result;
    }

    public static void helper(ArrayList<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start != s.length())
                return;
            result++;
            return;
        }

        for (int i = start; i < s.length() && i < start + 3; i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                helper(list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return s.equals("0");
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}
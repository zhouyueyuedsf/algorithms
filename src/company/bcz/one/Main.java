package company.bcz.one;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = (input.nextInt());
        if (num < 0) {
            System.out.print("-");
        }
        num = Math.abs(num);
        while (num != 0) {
            if (num % 10 != 0) {
                System.out.print(num % 10);
            }
            num /= 10;
        }


//        Scanner scanner = new Scanner(System.in);
//        String source = scanner.nextLine();
//        int len = source.length();
//        if (len == 0) {
//            System.out.println(0);
//        }
//        StringBuilder builder = new StringBuilder();
//        int min = 0;
//        if (source.charAt(0) == '-') {
//            builder.append('-');
//            min = 1;
//        }
//        boolean flag = true;
//        for (int i = len - 1; i >= min; i--) {
//            char c = source.charAt(i);
//            if (source.charAt(i) != '0') {
//                flag = false;
//            }
//            if (!flag) {
//                builder.append(c);
//            }
//        }
//
//        System.out.println(Integer.parseInt(builder.toString()));
    }
}

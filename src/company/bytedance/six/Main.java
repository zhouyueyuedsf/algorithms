package company.bytedance.six;

import java.util.Scanner;
import java.util.Stack;

class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        char[] c = inputStr.toCharArray();
        Stack<String> records = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'i') {
                if (!records.isEmpty()) {
                    String popStr = records.peek();
                    records.push(popStr.substring(0, popStr.length() - 1));
                }
            } else if (c[i] == 'o') {
                if (!records.isEmpty()) {
                    records.pop();
                }
            } else {
                if (!records.isEmpty()) {
                    records.push(records.peek() + c[i]);
                } else {
                    String s = String.valueOf(c[i]);
                    records.push(s);
                }
            }
        }
        System.out.println(records.peek());

    }
}

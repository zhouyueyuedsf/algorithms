package company.sina;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static boolean isRight(String s) {
        Stack<Character> sta = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                sta.push(')');
            else if (c == '{')
                sta.push('}');
            else if (c == '[')
                sta.push(']');
            else if (sta.isEmpty() || sta.pop() != c)
                return false;
        }
        return sta.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(isRight(str));
    }
}

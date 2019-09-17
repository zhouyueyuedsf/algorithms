package leetcode.stack;

import java.util.Stack;

// 简单计算器
public class _224 {

    public static int cal(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c == '(' || c == '+' || c == '-') {
                    stack.push(String.valueOf(c));
                } else if (c == ')') {
                    int sum = getSum(stack);
                    stack.pop();
                    stack.push(String.valueOf(sum));
                } else {
                    StringBuilder builder = new StringBuilder();
                    while (c >= '0' && c <= '9') {
                        builder.append(c);
                        if (++i < s.length()) {
                            c = s.charAt(i);
                        } else {
                            break;
                        }
                    }
                    String curValue = builder.toString();
                    if (stack.empty()){
                        stack.push(curValue);
                        continue;
                    }

                    stack.push(builder.toString());

                    continue;
                }

            }
            i++;
        }
        return getSum(stack);
    }

    private static int getSum(Stack<String> stack) {
        Stack<String> reverseStack = new Stack<>();
        while (!stack.empty() && !"(".equals(stack.peek())){
            reverseStack.push(stack.pop());
        }
        int sum = 0;
        while (!reverseStack.empty()) {
            String str = reverseStack.pop();
            if ("+".equals(str)) {
                sum += Integer.valueOf(reverseStack.pop());
            } else if ("-".equals(str)) {
                sum -= Integer.valueOf(reverseStack.pop());
            } else {
                sum = Integer.valueOf(str);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(cal(
                "(1 + 1"));
    }
}

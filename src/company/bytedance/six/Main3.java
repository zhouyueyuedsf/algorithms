package company.bytedance.six;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    private static String cvtTo(String str) {
        if (str.length() == 1) {
            return str.toLowerCase();
        }
        StringBuilder result = new StringBuilder();
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        for (int i = 1; i < str.length() -  1; i++) {
            if (Character.isUpperCase(str.charAt(i))
                    && !(Character.isUpperCase(str.charAt(i - 1)) && Character.isUpperCase(str.charAt(i + 1)))) {
                integers.add(i);
            }
        }

        if (Character.isUpperCase(str.charAt(str.length() - 1)) && Character.isLowerCase(str.charAt(str.length() - 2))) {
            integers.add(str.length() - 1);
        }

        String newVar = str.toLowerCase();
        for (int i = 0; i < integers.size() - 1; i++) {
            result.append(newVar.substring(integers.get(i), integers.get(i + 1))).append("_");
        }
        result.append(newVar.substring(integers.get(integers.size() - 1)));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            strs.add(scanner.next());
        }
        for (int i = 0; i < num; i++) {
            System.out.println(cvtTo(strs.get(i)));
        }
    }
}
package company.bcz.one.twi;

import java.util.*;

public class Main3 {

    public static boolean flag = false;
    public static void helper(int sum, int[] arr, int index)
    {
        if (flag) {
            return;
        }
        if (index < 0)
            return;

        if (sum == arr[index])
        {
            flag = true;
        }
        helper(sum - arr[index], arr, index - 1);
        helper(sum, arr, index - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        helper(k, arr, num - 1);
        System.out.println(flag);
    }

}

package company.aqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static boolean flag = false;
    public static int count = 0;
    public static void helper(int sum, int[] arr, int index)
    {
        if (flag) {
            return;
        }

        if (sum < 0) return;

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
        String s = scanner.nextLine();

        int[] pre = new int[3];
        int preNum = 0;

        int[] after = new int[3];
        int afterNum = 0;
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                pre[i] = Integer.parseInt(s.substring(i, i + 1));
                preNum += pre[i];
            } else {
                after[i - 3] = Integer.parseInt(s.substring(i, i + 1));
                afterNum += after[i - 3];
            }
        }
        Arrays.sort(pre);
        Arrays.sort(after);

        int[] sub = new int[3];
        int[] add = new int[3];

        int value = Math.abs(preNum - afterNum);
        if (preNum < afterNum) {
            for (int i = 0; i < 3; i++) {
                add[i] = 9 - pre[i];
            }
            for (int i = 0; i < 3; i++) {
                sub[i] = after[2 - i];
            }
        } else if (preNum > afterNum){
            for (int i = 0; i < 3; i++) {
                add[i] = 9 - after[i];
            }
            for (int i = 0; i < 3; i++) {
                sub[i] = pre[2 - i];
            }
        } else {
            System.out.println(0);
            return;
        }

        int max = Math.max(sub[0], pre[0]);
        int[] arr = new int[max + 1];
        for (int i = max; i >= 0; i--) {
            arr[i] = i;
        }
        helper(value, arr, max);
        System.out.println(count);
    }
}

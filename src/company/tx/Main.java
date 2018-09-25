package company.tx;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++){
            arr[i] = scanner.nextInt();
        }
        int preIndex = -1;
        int res = 1;
        boolean flag = false;
        boolean isValid = true;
        for (int i = 0; i < num; i++) {
            if (flag && arr[i] == 1) {
                int temp = i - preIndex;
                if (temp > 1) {
                   res = res * temp;
                }
                preIndex = i;
            }
            if (arr[i] == 1) {
                flag = true;
                preIndex = i;
            }
        }

        System.out.println(res);
    }
}

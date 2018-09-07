package company.meituan.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n + 1];
        List<Integer> lowIndex = new ArrayList<>();
        lowIndex.add(0);
        arr[0] = -1;
        for (int i = 1; i < n + 1; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        int pre = arr[0];
        boolean findLow = false;
        boolean findHigh = true;
        for (int i = 1; i < n + 1; i++) {
            int cur = arr[i];
            if (cur < pre) {
                //波谷
                lowIndex.add(i);
                if (findHigh) {
                    int count = 1;
                    //往前找波谷
                    for (int j = lowIndex.size() - 1; j >= 0; j--) {
                        if (arr[lowIndex.get(j)] < cur) {
                            count = i - lowIndex.get(j);
                            break;
                        }
                    }
                    //往后找波谷
                    int preTemp = cur;
                    for (int j = i + 1; j < n + 1; j++) {
                        int curTemp = arr[j];
                        if (preTemp > curTemp) {
                            break;
                        } else {
                            count++;
                        }
                    }
                    max = Math.max(max, count * cur);
                    lowIndex.add(i);
                    findLow = true;
                    findHigh = false;
                }
            } else if (findLow) {
                //往后找波谷
                int count = 1;
                int preTemp = cur;
                for (int j = i + 1; j < n + 1; j++) {
                    int curTemp = arr[j];
                    if (preTemp > curTemp) {
                        break;
                    } else {
                        count++;
                    }
                }
                max = Math.max(max, count * cur);
                findLow = false;
                findHigh = true;
            }
            pre = cur;
        }
        System.out.println(max);
    }
}

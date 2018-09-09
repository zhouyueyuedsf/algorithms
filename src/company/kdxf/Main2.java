package company.kdxf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    static int value = 0;
    // //参数：数组，数组大小
    public static int[] findPeaks(int[] num, int count) {

        List<Integer> sign = new ArrayList<Integer>();
        for (int i = 1; i < count; i++) {
            /* 相邻值做差： *小于0，，赋-1 *大于0，赋1 *等于0，赋0 */
            int diff = num[i] - num[i - 1];
            if (diff > 0) {
                sign.add(1);
            } else if (diff < 0) {
                sign.add(-1);
            } else {
                sign.add(0);
            }
        }
        // 再对sign相邻位做差
        // 保存极大值和极小值的位置
        List<Integer> indMax = new ArrayList<Integer>();
        for (int j = 1; j < sign.size(); j++) {
            int diff = sign.get(j) - sign.get(j - 1);
            if (diff < 0) {
                indMax.add(j);
            }
        }
        int[] res = new int[indMax.size()];
        for (int m = 0; m < indMax.size(); m++) {
            res[m] = num[indMax.get(m)];
        }
        return res;
//        System.out.println("极大值为:");
//        for (int m = 0; m < indMax.size(); m++) {
//            System.out.print(num[indMax.get(m)] + " ");
//        }
//        System.out.println();
//        System.out.println("极小值为:");
//        for (int n = 0; n < indMin.size(); n++) {
//            System.out.print(num[indMin.get(n)] + " ");
//        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[10];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
//        findPeaks(a, 10);
        helper(a, 10);
        System.out.println(value);
    }

    private static void helper(int[] num, int count) {
        int[] a = findPeaks(num, count);
        if (a.length == 1) {
            return;
        } else {
            helper(a, a.length);
            value++;
        }

    }

}

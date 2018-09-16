package company.bcz.one.twi;

import java.util.Scanner;

public class Main2 {

    private static boolean res = false;

    //输入t， r， 尝试Wk
    public static void SumOfkNumber(int t, int k, int r, int M, boolean flag, boolean[] X)
    {

        if (res) {
            return;
        }

        X[k] = true;   // 选第k个数
        if (t + k == M) // 若找到一个和为M，则设置解向量的标志位，输出解
        {
            flag = true;
            for (int i = 1; i <= k; ++i)
            {
                if (X[i])
                {
                    res = true;
                }
            }
        }
        else
        {   // 若第k+1个数满足条件，则递归左子树
            if (t + k + (k + 1) <= M)
            {
                SumOfkNumber(t + k, k + 1, r - k, M, flag, X);
            }
            // 若不选第k个数，选第k+1个数满足条件，则递归右子树
            if ((t + r - k >= M) && (t + (k + 1) <= M))
            {
                X[k] = false;
                SumOfkNumber(t, k + 1, r - k, M, flag, X);
            }
        }
    }

    public static void search(int N, int num, int M)
    {
        // 初始化解空间
        boolean[] X = new boolean[num + 1];

        int sum = (int) ((num + 1) * num * 0.5f);
        if (1 > M || sum < M) // 预先排除无解情况
        {
            System.out.println(false);
            return;
        }
        boolean f = false;
        SumOfkNumber(0, 1, sum, M, f, X);
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            if (arr[i] == k) {
                System.out.println(true);
                return;
            }
        }

    }

}

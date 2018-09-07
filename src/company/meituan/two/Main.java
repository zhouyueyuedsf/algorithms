package company.meituan.two;

import java.util.Scanner;

public class Main {

    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        boolean[][] graph = new boolean[num][num];
        for (int i = 0; i < num - 1; i++) {
            String str = scanner.nextLine();
            String strs[] = str.split(" ");
            int m = Integer.valueOf(strs[0]) - 1;
            int n = Integer.valueOf(strs[1]) - 1;
            graph[m][n] = true;
        }

        //DFS
        dfs(graph, num, 0);
        System.out.println(res);
    }


    private static void dfs(boolean[][] graph, int num, int start) {
        for (int i = 0; i < num; i++) {
            if (graph[start][i]) {
                dfs(graph, num, i);
            }
        }
        res++;
    }
}

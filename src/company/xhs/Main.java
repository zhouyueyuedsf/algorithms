package company.xhs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static int bfs(int[][] graphm, int[] color, int start, int n){
        color[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            int from = queue.poll();
            for(int i = start; i < n; i++)
            {
                // 如果相邻的点没有上色就给这个点上色
                if(graphm[from][i] == 1 && color[i] == 0)
                {
                    queue.add(i);
                    color[i] = -color[from];
                }
                // 如果相邻的颜色相同则返回false
                if(graphm[from][i] == 1 && color[i] == color[from])
                    return 0;
            }
        }
        // 如果所有的点都被染过色，且相邻的点颜色都不一样，返回true
        return 1;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rn = scanner.nextInt();

        int[][] graph = new int[n][n];
        int[] color = new int[n];
        for (int i = 0; i < rn; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            graph[v][w] = 1;
        }

        System.out.println(bfs(graph, color, 0, n));
    }
}

package company.meituan.two;

import common.DFS;
import common.Graphl;

import java.util.Scanner;

public class Main2 {

    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        Graphl graphl = new Graphl(num);
        for (int i = 0; i < num - 1; i++) {
            String str = scanner.nextLine();
            String strs[] = str.split(" ");
            int m = Integer.valueOf(strs[0]) - 1;
            int n = Integer.valueOf(strs[1]) - 1;
            graphl.setEdge(m, n, 1);
            graphl.setEdge(n, m, 1);
        }

        DFS.DFS(graphl, 1);
    }


}

package company.bytedance.four;

import common.Graphl;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        Graphl graphl = new Graphl(M * M);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int value = scanner.nextInt();
                if (value == 0) {
                    continue;
                }
                if (i - 1 > 0) {
                    graphl.setEdge(i * j, 0, value);
                }
                if (i + 1 < M ) {
                    graphl.setEdge(i * j, 1, value);
                }
                if (j - 1 > 0) {
                    graphl.setEdge(i * j, 2, value);
                }
                if (j + 1 < M) {
                    graphl.setEdge(i * j,  2, value);
                }
            }
        }
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < M; j++) {
//                DFS(graphl, i);
//            }
//        }
        System.out.println(graphl.mapHeaders.size());
    }
    static int count = 0;

    public static void DFS(Graphl g, int v) {
        g.setMark(v, true);
        int w;
        for (w = g.first(v); w < g.numVertex; w = g.next(v, w)) {
            if (!g.getMark(w)) {
                DFS(g, w);
            }
        }
    }


}
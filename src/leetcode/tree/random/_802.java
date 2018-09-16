package leetcode.tree.random;

import java.util.ArrayList;
import java.util.List;

public class _802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //graph为图的链表表示，只不过用矩阵形式
        int len = graph.length;
        int[] mark = new int[len];
        for (int i = 0; i < len; i++) {
            if (DFS(graph, mark, len, i)){
                res.add(i);
            };
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public boolean DFS(int[][] graph, int[] mark, int len, int w) {
        if (mark[w] > 2) {
            return mark[w] == 2;
        }
        mark[w] = 1;
        for (int i = 0; i < graph[w].length; i++) {
            int v = graph[w][i];
            if (mark[w] == 2) continue;
            if (mark[v] == 1 || !DFS(graph, mark, len, v)) {
                return false;
            }
        }
        mark[w] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        int[][] arr1 = {{0}, {2, 3, 4}, {3, 4}, {0, 4}, {}};
        int[][] arr2 = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
        int[][] arr3 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        _802 run = new _802();
        run.eventualSafeNodes(arr3);
    }
}

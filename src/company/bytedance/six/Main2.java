package company.bytedance.six;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {


    /**
     * 链表表示的图
     */
    public static class Graphl {

        class GraphlNode{
            /**
             * 每个节点的唯一标识
             */
            int key;
            public GraphlNode next = null;
            public GraphlNode tail = null;
            int weight;
            public GraphlNode(int key) {
                this.key = key;
            }
        }
        /**
         * hashmap
         * key: 表示头结点
         */
        public HashMap<Integer, GraphlNode> mapHeaders = new HashMap<>();
        boolean[] mark;
        public int numVertex;

        public Graphl(int n) {
            init(n, true);
        }

        public void init(int n, boolean isInitMark) {
            if (isInitMark) {
                mark = new boolean[n];
            }
            numVertex = n;
        }

        /**
         *
         * @param v
         * @param w
         * @param weight 边的权值
         */
        public void setEdge(int v, int w, int weight) {
            if (mapHeaders.containsKey(v)) {
                GraphlNode cur = mapHeaders.get(v);
                GraphlNode head = cur;
                cur = (cur.tail.next = new GraphlNode(w));
                cur.weight = weight;
                head.tail = cur;
            } else {
                GraphlNode head = new GraphlNode(v);
                mapHeaders.put(v, head);
                head.next = new GraphlNode(w);
                head.tail = head.next;
                head.tail.weight = w;
            }
        }

        public void removeEdge(int v, int w) {
            if (mapHeaders.containsKey(v)) {
                GraphlNode cur = mapHeaders.get(v);
                while (cur != null) {
                    if (cur.next != null && cur.next.key == w) {
                        cur.next = cur.next.next;
                    }
                    cur = cur.next;
                }
            }
        }

        public int first(int v) {
            GraphlNode cur = mapHeaders.get(v);
            //w刚好是最后，用numVertex表示是最后
            if (cur == null) {
                return numVertex;
            }
            if (cur.next == null) {
                return numVertex;
            } else {
                return cur.next.key;
            }
        }

        public int next(int v, int w) {
            GraphlNode cur = mapHeaders.get(v);
            if (cur == null) {
                return numVertex;
            }
            while (cur.key != w) {
                cur = cur.next;
            }
            //w刚好是最后，用numVertex表示是最后
            if (cur.next == null) {
                return numVertex;
            } else {
                return cur.next.key;
            }
        }

        public void setMark(int v, boolean isMark) {
            mark[v] = isMark;
        }

        public void reSetMark() {
            for (int i = 0; i < mark.length; i++) {
                mark[i] = false;
            }
        }

        public boolean getMark(int v) {
            return mark[v];
        }



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //构建图
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graphl graphl = new Graphl(n);

        int[][] index = new int[m][2];
        for (int i = 0; i < m; i++) {
            index[i][0] = scanner.nextInt();
            index[i][1] = scanner.nextInt();
            graphl.setEdge(index[i][0] - 1, index[i][1] - 1, 1);
            graphl.setEdge(index[i][1] - 1, index[i][0] - 1, 1);
        }
        int[] cs = new int[m];
        for (int i = 0; i < m; i++) {
            int c = scanner.nextInt();
            cs[i] = c;
        }
        for (int i = 0; i < m; i++) {
            int c = cs[i];
            int start = index[c - 1][0];
            int end = index[c - 1][1];
            graphl.removeEdge(start - 1, end - 1);
            graphl.removeEdge(end - 1, start - 1);
            DFS(graphl, start - 1);
            if (count != n) {
                System.out.println(i + 1);
                break;
            }
            count = 0;
            graphl.reSetMark();
        }
    }
    public static int count = 0;
    public static void DFS(Graphl g, int v) {
//        System.out.println(v);
        g.setMark(v, true);
        count++;
        for (int w = g.first(v); w < g.numVertex; w = g.next(v, w)) {
            if (!g.getMark(w)) {
                DFS(g, w);
            }
        }
    }
}

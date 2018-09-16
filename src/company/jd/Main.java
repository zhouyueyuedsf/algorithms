package company.jd;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.HashMap;

/**
 * 链表表示的图
 */
class Graphl {

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
            GraphlNode h = cur;
            cur = (cur.tail.next = new GraphlNode(w));
            cur.weight = weight;
            h.tail = cur;
        } else {
            GraphlNode head = new GraphlNode(v);
            mapHeaders.put(v, head);
            head.next = new GraphlNode(w);
            head.tail = head.next;
            head.tail.weight = weight;
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

    public boolean getMark(int v) {
        return mark[v];
    }



}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int pointNum = scanner.nextInt();
            int edgeNum = scanner.nextInt();
            Graphl graphl = new Graphl(pointNum);

            for (int j = 0; j < edgeNum; j++) {
                int w = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                graphl.setEdge(v, w, 1);
                graphl.setEdge(w, v, 1);
            }
            System.out.println(helper(graphl) ? "YES" : "NO");
        }
        //输入
    }

    public static boolean helper(Graphl g){
        List<List<Integer>> listSet = new ArrayList<>();

        for (int i = 0; i < g.numVertex; i++) {
//            if (!g.getMark(i)) {
//                List<Integer> set1 = new ArrayList<>();
//                set1.add(i);
//                listSet.add(set1);
//                g.setMark(i, true);
//            }
            int v = g.first(i);
//            if (!g.getMark(v)) {
//                List<Integer> set2 = new ArrayList<>();
//                set2.add(v);
//                g.setMark(v, true);
//                listSet.add(set2);
//            }
            int w ;
            v = i;
            while (v < g.numVertex) {
                //判断是否应该在set集合中
                if (!g.getMark(v) && !addAndNewSet(g, v, listSet)) {
                    return false;
                };
                v = g.next(i, v);
            }
        }
        return true;
    }

    private static boolean addAndNewSet(Graphl g, int w, List<List<Integer>> listSet) {
        //记录有连边的集合
        int count1 = 0;
        //记录没有连边的集合
        int count2 = 0;
        for (List<Integer> set : listSet) {
            int cur = g.first(w);
            boolean flag = false;
            //计算集合里面的每个值是否与w节点相连
            for (int v : set) {
                while (cur != v) {
                    count1++;
                    flag = true;
                    cur = g.next(w, cur);
                    break;
                }
                if (!flag) {
                    count2++;
                }
            }

        }

        if (count1 == listSet.size()) {
            List<Integer> newSet = new ArrayList<>();
            newSet.add(w);
            listSet.add(newSet);
            return true;
        }

        if (count1 == 1 && count2 == listSet.size() - 1) {
            return true;
        }


        return false;
    }
}

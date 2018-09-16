package common;


import java.util.HashMap;

/**
 * 链表表示的图
 */
public class Graphl {

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
            cur = (cur.tail.next = new GraphlNode(w));
            cur.weight = weight;
            cur.tail = cur;
        } else {
            GraphlNode head = new GraphlNode(v);
            mapHeaders.put(v, head);
            head.next = new GraphlNode(w);
            head.tail = head.next;
            head.tail.weight = w;
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

package common;

public class DFS {

    /**
     * 深度优先搜索
     * @param g 链表表示的图
     * @param v 开始搜索的起始节点
     */
    public static void DFS(Graphl g, int v) {
        System.out.println(v);
        g.setMark(v, true);
        for (int w = g.first(v); w < g.numVertex; w = g.next(v, w)) {
            if (!g.getMark(w)) {
                DFS(g, w);
            }
        }
    }


}

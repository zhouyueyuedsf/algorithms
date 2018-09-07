package common;

/**
 * 图的矩阵表示
 */
public class Graphm {

    /**
     * matrix[i][j]表示节点i到j的权重
     */
    int[][] matrix;
    int numVertex;
    boolean[] mark;

    Graphm(){

    }

    Graphm(int n) {
        init(n, true);
    }

    public void init(int n, boolean isInitMark) {
        numVertex = n;
        matrix = new int[n][n];
        if (isInitMark) {
            mark = new boolean[n];
        }
    }

    /**
     * 赋权值
     */
    public void setEdge(int v, int w, int weight) {
        matrix[v][w] = weight;
    }


    public int first(int v) {
        for (int i = 0; i < numVertex; i++) {
            if (matrix[v][i] != 0) {
                return i;
            }
        }
        return numVertex;
    }

    /**
     * 返回在w后的v的邻居
     * @param v
     * @param w
     * @return
     */
    public int next(int v, int w) {
        for (int i = w + 1; i < numVertex; i++) {
            if (matrix[v][i] != 0) {
                return i;
            }
        }
        // 如果为空返回n
        return numVertex;
    }

    public void setMark(int v){
        mark[v] = true;
    }
}

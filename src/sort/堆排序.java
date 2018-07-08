package sort;

import common.Utils;



/**
 * 优先队列
 * 1. 建堆（最大堆，最小堆）buildHeap（循环）siftDown（递归/循环）
 * 2. 排序
 */
public class 堆排序 {



    private int leftSibling(int i){
        return i - 1;
    }

    private int rightSibling(int i){
        return i + 1;
    }

    private int leftChild(int i){
        return 2 * i + 1;
    }

    private int rightChild(int i){
        return 2 * i + 2;
    }

    private boolean isLeaf(int n, int i){
        return leftChild(i) > n - 1;
    }

    /**
     * 局部调整
     * @param heap
     * @param cur
     * @see #buildHeap(int[])
     */
    public void siftDown(int[] heap, int n, int cur){
        //循环
        //思想：索引为i的节点与左右叶节点比较，如果都大于则不动，如果小于任何一个则取左右子节点最大的交换
        while(!isLeaf(n, cur)){
            int left = leftChild(cur);
            int right = rightChild(cur);
            int max = left;
            if(right < n &&heap[max] < heap[right]){
                max = right;
            }
            if(heap[max] > heap[cur]){
                //交换
                Utils.swap(heap, max, cur);
            }
            cur = max;
        }
    };

    /**
     * 建立最大堆
     * @param heap
     */
    private void buildHeap(int[] heap){
        //完全二叉树
        //找到完全二叉树的第一个非叶节点->最后一个节点是heap(n-1)->其父节点便是第一个非叶结点即heap(n/2 - 1)
        int n = heap.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(heap, n, i);
        }
    }

    private void removeFirst(int[] heap, int n){
        //交换第一个节点与最后一个叶节点的位置
        Utils.swap(heap, 0, --n);
        if (n > 0){
            siftDown(heap, n - 1, 0);
        }
    }

    private void sort(int[] heap){
        buildHeap(heap);
        int n = heap.length;
        while (n > 0) {
            removeFirst(heap, n);
            n--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,31,241,41,214,14};
        堆排序 run = new 堆排序();
        run.sort(arr);
        System.out.println(arr);
    }
}

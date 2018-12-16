package sort;

import common.Utils;

public class 快速排序 {

    public static int partition(int[] arr, int l, int r, int pivot){
        while (l < r) {
            while (l < r && l < pivot) l++;
            while (l < r && r > pivot) r--;

            Utils.swap(arr, l, r);
        }
        Utils.swap(arr, l, pivot);
        return l;
    }
    public void quickSort(int[] arr, int left, int right) {
        int pivot = right;

        int mid = partition(arr, left, right - 1, pivot);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid, right);
    }
}

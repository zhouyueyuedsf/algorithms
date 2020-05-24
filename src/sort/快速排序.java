package sort;

import common.Utils;

public class 快速排序 {

    public static int partition(int[] arr, int l, int r, int pivot) {
        while (l < r) {
            while (l < r && l < pivot) l++;
            while (l < r) r--;

            Utils.swap(arr, l, r);
        }
        Utils.swap(arr, l, pivot);
        return l;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int mid = partition(arr, left, right - 1, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid, right);
    }

    public static void main(String[] args) {
        快速排序.quickSort(new int[]{1, 2}, 0, 1);
    }
}


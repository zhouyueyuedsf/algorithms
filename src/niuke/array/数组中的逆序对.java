package niuke.array;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 数组中的逆序对 {

    int count = 0;
    private void mergeSort(int[] arr, int n, int left, int right){
        if(right - left <= 0) return;
        if(right - left == 1){
            if(arr[left] >  arr[right]){
                Utils.swap(arr, left, right);
                count++;
            }
            return;
        }
        // 分
        int mid = (left + right) / 2;
        mergeSort(arr, n, left, mid);
        mergeSort(arr, n, mid + 1, right);

        // 合 难点 相当于合并两个有序数组
        mergeOrderArr(arr, left, right, mid);
    }

    private void mergeOrderArr(int[] arr, int left, int right, int mid) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                count += mid - i + 1;
                j++;
            }
            index++;
        }
        if (temp.length == 8) {
            System.out.println(1);
        }
        if (i > mid) {
            for (int k = j; k <= right; k++) {
                temp[index] = arr[k];
                index++;
            }
        } else if (j > right) {
            for (int k = i; k <= mid; k++) {
                temp[index] = arr[k];
                index++;
            }
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }
    public int InversePairs(int [] array) {
        mergeSort(array, array.length, 0, array.length - 1);
        return count;
    }
    public static void main(String[] args) {
        数组中的逆序对 run = new 数组中的逆序对();
        System.out.println(run.InversePairs(new int[]{}));;
    }
}

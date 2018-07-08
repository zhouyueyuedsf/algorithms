package sort;


import common.Utils;

/**
 * 先分，分到len=2为止，再合并
 */
public class 归并排序 {

    private void mergeSort(int[] arr, int n, int left, int right){
        if(right - left < 2){
            if(arr[left] >  arr[right]){
                Utils.swap(arr, left, right);
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
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        if(temp.length == 8){
            System.out.println(1);
        }
        if(i > mid){
            for (int k = j; k <= right; k++){
                temp[index] = arr[k];
                index++;
            }
        } else if (j > right){
            for (int k = i; k <= mid; k++){
                temp[index] = arr[k];
                index++;
            }
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }

    public void mergeSort(int[] arr){
        mergeSort(arr, arr.length, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        归并排序 run = new 归并排序();
        int[] arr = {2,1,4,1,24,1,51,24};
        run.mergeSort(arr);
        System.out.println(arr);
    }
}

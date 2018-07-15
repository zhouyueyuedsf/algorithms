package niuke.array;

public class 数字在排序数组中出现的次数 {

    public int GetNumberOfK(int[] array, int k) {
        int res = 0;
        for (int a : array) {
            if (a == k) {
                res++;
            }
        }
        return res;
    }

    /**
     * 二分法 找到第一个k 和最后一个k。两者相减
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfKInBinary(int[] array, int k) {
        int res = 0;
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, len - 1);
        int lastK = getLastK(array, k, 0, len - 1);
        return lastK - firstK + 1;
    }

    /**
     * 递归写法
     *
     * @param array
     * @param k
     */
    private int getFirstK(int[] array, int k, int left, int right) {
        if (right - left <= 1) {
            if (array[left] == k) {
                return left;
            } else if (array[right] == k) {
                return right;
            }
            return -1;
        }
        int mid = (left + right) >> 1;

        if (array[mid] > k) {
            return getFirstK(array, k, left, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, right);
        } else {
            return getFirstK(array, k, left, mid);
        }

    }

    /**
     * loop for binary
     *
     * @param array
     * @param k
     * @param left
     * @param right
     * @return
     */
    private int getLastK(int[] array, int k, int left, int right) {

        while (right - left > 1) {
            int mid = (left + right) >> 1;

            if (array[mid] < k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (array[right] == k) {
            return right;
        } else if (array[left] == k) {
            return left;
        }
        return -2;
    }

    /**
     * 此函数的目的是为了研究left与right的位置关系。功能是在已排序数组中，找出最后一个k值
     *
     * @param array
     * @param k
     * @param left
     * @param right
     * @return
     */
    public int getLastKTest(int[] array, int k, int left, int right) {
        int mid = (left + right) >> 1;

        while (left <= right) {

            if (array[mid] <= k) {
                left = mid + 1;
            } else if (array[mid] > k) {
                right = mid - 1;
            }
            mid = (left + right) >> 1;
        }

        return right;
    }

    public static void main(String[] args) {
        数字在排序数组中出现的次数 run = new 数字在排序数组中出现的次数();
//        System.out.println(run.GetNumberOfKInBinary(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5}, 5));
        System.out.println(run.getLastKTest(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5}, 2, 0, 11));
    }
}

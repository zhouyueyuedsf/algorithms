package niuke;


import java.util.ArrayList;

public class 丑数 {

    public int nthUglyNumber(int n) {
        // write your code here
        int[][] base = {{1, 2}, {1, 2, 3}, {1, 2, 3, 5}};
        int[] source = {2, 3, 5};
        int i0 = 0, i1 = 0, i2 = 0;
        int count = 1;
        int min = 1;
        while (count != n) {
            int v0 = base[0][i0] * source[0];
            int v1 = base[1][i1] * source[1];
            int v2 = base[2][i2] * source[2];
            min = Math.min(Math.min(v0, v1), v2);
            count++;
            if (min == v0) {
                i1 = maybeMerge1(source, i1, v1);
                i0 = (i0 + 1) % 2;
                i2 = maybeMerge2(source, i2, v2);
            }
            if (min == v1) {
                i0 = maybeMerge0(source, i0, v0);
                i1 = (i1 + 1) % 3;
                i2 = maybeMerge2(source, i2, v2);
            }
            if (min == v2) {
                i0 = maybeMerge0(source, i0, v0);
                i2 = (i2 + 1) % 4;
                i1 = maybeMerge1(source, i1, v1);
            }
        }
        return min;
    }

    private int maybeMerge0(int[] source, int i0, int v0) {
        if ((1 + i0) % 2 == 0) {
            i0 = 0;
            source[0] = v0;
        }
        return i0;
    }

    private int maybeMerge1(int[] source, int i1, int v1) {
        if ((1 + i1) % 3 == 0) {
            i1 = 0;
            source[1] = v1;
        }
        return i1;
    }

    private int maybeMerge2(int[] source, int i2, int v2) {
        if ((1 + i2) % 4 == 0) {
            i2 = 0;
            source[2] = v2;
        }
        return i2;
    }

    public int nthUglyNumber2(int n) {
        // write your code here
        ArrayList<Long> minList = new ArrayList<Long>();
        int[] bases = {2,3,5};
        int count = 1;
        long min = 1;
        minList.add(-1L);
        minList.add(min);
        while(n != count){
            Long tail = minList.get(minList.size() - 1);
            int curIndex = minList.size() - 1;
            Long tempMin = Long.MAX_VALUE;
            for (int base : bases) {
                for (int j = curIndex; j >= 0; j--) {
                    Long cur = minList.get(j);
                    if (base * cur <= tail) {
                        curIndex = j + 1;
                        Long curMin = minList.get(curIndex) * base;
                        if (curMin < tempMin && !curMin.equals(tail)) {
                            tempMin = curMin;
                        }
                        break;
                    }
                }
            }
            minList.add(tempMin);
            count++;
        }
        return Math.toIntExact(minList.get(minList.size() - 1));
    }

    public static int getUglyNumber2(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] pUglyNumbers = new int[index];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index) {
            int min = min(pUglyNumbers[p2] * 2, pUglyNumbers[p3] * 3, pUglyNumbers[p5] * 5);
            pUglyNumbers[nextUglyIndex] = min;
            while (pUglyNumbers[p2] * 2 <= pUglyNumbers[nextUglyIndex]) {
                p2++;
            }
            while (pUglyNumbers[p3] * 3 <= pUglyNumbers[nextUglyIndex]) {
                p3++;
            }
            while (pUglyNumbers[p5] * 5 <= pUglyNumbers[nextUglyIndex]) {
                p5++;
            }
            nextUglyIndex++;
        }
        return pUglyNumbers[nextUglyIndex - 1];
    }
    private static int min(int n1, int n2, int n3) {
        int min = n1 < n2 ? n1 : n2;
        return min < n3 ? min : n3;
    }
    public static void main(String[] args) {

        丑数 run = new 丑数();
        System.out.println(run.getUglyNumber2(10) + "");

    }
}

package leetcode.array;

public class _11 {

    private int test(int[] height) {
        int n = height.length;
        int headPoint = 0;
        int tailPoint = n - 1;
        int max = 0;
        while (headPoint < tailPoint) {
            if (height[headPoint] < height[tailPoint]) {
                max = Math.max(height[headPoint] * (tailPoint - headPoint), max);
                headPoint++;
            } else {
                max = Math.max(height[tailPoint] * (tailPoint - headPoint), max);
                tailPoint--;
            }
        }
        return max;
    }
}

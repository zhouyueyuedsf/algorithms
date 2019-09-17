package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 这道题可以深度理解栈的性质
 * 栈可以删除某些多余的步骤.其实也是淘汰机制(淘汰了某些步骤)，可以研究下1，2，3，4，5，6与6,5,4,3,2,1的区别
 */
public class _84 {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0;
        int count = 0;
        while (i < heights.length || !stack.isEmpty()) {
            count++;
            //递增栈
            if (stack.isEmpty() || (i < heights.length && heights[i] >= heights[stack.peek()])) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                //由于是递增栈，所以如果栈内为空即目前的值就是全局最小值，即取i
                int width = (stack.isEmpty()) ? i : i - 1 - stack.peek();
                int area = width * heights[top];
                maxArea = Math.max(area, maxArea);
            }
        }
        System.out.println(count);
        return maxArea;
    }

    /**
     * 复杂度较高的算法
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int max = 0;
        // int tempMin = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < len; i++){
            int tempMin = Integer.MAX_VALUE;
            for(int j = i; j >= 0; j--){
                count++;
                if(heights[j] < tempMin){
                    tempMin = heights[j];
                }
                max = Math.max(Math.min(tempMin, Math.min(heights[i], heights[j])) * (i - j + 1), max);
            }
        }
        System.out.println(count);
        return max;
    }

    public static void main(String[] args) {
        _84.largestRectangleArea(new int[]{6, 5, 4, 3, 2, 1});
//        _84.largestRectangleArea2(new int[]{6, 5, 4, 3, 2, 1});
    }
}

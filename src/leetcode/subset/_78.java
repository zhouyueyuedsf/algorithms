package leetcode.subset;

import java.util.ArrayList;
import java.util.List;

public class _78 {
    private static List<List<Integer>> ans = new ArrayList<>();

    // 记录是否选择该元素
    private static boolean[] v = new boolean[100];
    // 此处的index代表的是数组的索引
    private static void robot(int index, int[] nums) {
        if (index >= nums.length) {

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (v[i]) {
                    temp.add(nums[i]);
                }
            }
            ans.add(temp);
            return;
        }

        // 以下两种情况中 true代表选择该元素   false代表不选择该元素
        v[index] = true;
        robot(index + 1, nums);
        v[index] = false;
        robot(index + 1, nums);
    }

    public static List<List<Integer>> subSet(int[] nums) {
        robot(0, nums);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        subSet(arr);
    }
}

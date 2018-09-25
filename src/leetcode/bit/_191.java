package leetcode.bit;

public class _191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = (n & n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        _191 run = new _191();
        System.out.println(run.hammingWeight(-2));
    }
}

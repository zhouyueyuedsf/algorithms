package niuke;

public class 整数中1出现的次数 {
    public int helper1(int n) {
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            //当前位
            current = (n / i) % 10;
            //高位
            before = n / (i * 10);
            //低位
            after = n - (n / i) * i;
            if (current == 0)
                count += before * i;
            else if (current == 1)
                count += before * i + after + 1;
            else {
                count += (before + 1) * i;
            }
            //前移一位
            i = i * 10;
        }
        return count;
    }

    public int helper2(int n) {
        String intS = String.valueOf(n);
        int len = String.valueOf(n).length();
        int[] r = new int[len];
        for (int i = len - 1; i > 0; i--) {
            r[i] = intS.charAt(i);
        }
        int sum = 1;
        for (int i = 1; i < len; i++) {
//            for (int k = 1; k < r[i]; k++) {
//                if(k == 1){
//                    sum += (int) (((10 * i + 1) + 10 * (i - 1) + 1) * (k * Math.pow(10, i) - 1));
//                } else {
//                    sum += (int) (sum + (10 * (i - 1) + 1) * (k * Math.pow(10, i) - 1));
//                }
//            }
        }
        return sum;
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        return helper1(n);
    }

    public static void main(String[] args) {
        整数中1出现的次数 run = new 整数中1出现的次数();
        System.out.println(run.NumberOf1Between1AndN_Solution(12));
    }
}

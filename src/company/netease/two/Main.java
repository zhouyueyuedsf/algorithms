package company.netease.two;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //列
        int n = scanner.nextInt();
        //行
        int m = scanner.nextInt();
//        scanner.next();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = scanner.nextInt();
        }

        int score = 0;

        ArrayList<Queue<Boolean>> queues = new ArrayList<>();

        //init

        for (int i = 0; i < n; i++) {
            queues.add(new ArrayDeque<>(2));
        }
        for (int i = 0; i < n; i++) {
            queues.get(nums[i] - 1).add(true);
        }

        for (int k = n; k < m; k++) {
            queues.get(nums[k] - 1).add(true);
            boolean flag = false;
            for (Queue<Boolean> queue : queues) {
                if (queue.size() == 0) {
                    flag = true;
                    continue;
                }
                if (!queue.peek()) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                score++;
                for (Queue<Boolean> queue : queues) {
                    queue.poll();
                }
            }
        }
        System.out.println(score);
    }
}

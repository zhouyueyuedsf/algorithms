package company.netease;



import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        //数据组数
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            //第i组id的数量
            int count = Integer.parseInt(scanner.nextLine());
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < count; j++) {
                list.add(scanner.nextInt());
            }
            scanner.nextLine();
            lists.add(list);
        }

        Solution2 solution2 = new Solution2();
        solution2.helper(lists);
    }


    private void helper(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            ListNode head = new ListNode(0);
            head.next = null;
            for (int integer : list) {
                ListNode node = head.next;
                ListNode pre = head;
                boolean isBreak = false;
                while (node != null) {
                    if (node.val == integer) {
                        pre.next = pre.next.next;
                        node.next = head.next;
                        head.next = node;
                        isBreak = true;
                        break;
                    }
                    pre = node;
                    node = node.next;
                }
                if (!isBreak) {
                    node = new ListNode(integer);
                    node.next = head.next;
                    head.next = node;
                }
            }
            ListNode node = head.next;
            String res = "";
            while (node != null) {
                res = res + node.val;
                if (node.next != null) {
                    res = res + " ";
                }
                node = node.next;
            }
            System.out.println(res);
        }
    }
}

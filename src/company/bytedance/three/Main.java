package company.bytedance.three;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
//        scanner.next();
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String[] strs = scanner.nextLine().split(" ");

            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int j = 0; j < strs.length - 1; j++) {
                int v = Integer.parseInt(strs[j]);
                if (v < i) {
                    graph.get(v).add(i);
                }
                linkedList.add(v);
            }
            graph.add(linkedList);
            hashMap.put(i, i);
        }

        //BFS
        boolean[] hash = new boolean[num];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int res = 0;
        while (hashMap.size() != 0){
            Iterator<Integer> iter = hashMap.keySet().iterator();
            queue.add(iter.next());
            while (queue.size() != 0) {
                hashMap.remove(queue.peek());
                int root = queue.poll();
                hash[root] = true;
                LinkedList<Integer> linkedList = graph.get(root);
                for (int v : linkedList) {
                    if (!hash[v]) {
                        hash[v] = true;
                        hashMap.remove(v);
                        queue.add(v - 1);
                    }
                }

            }
            res++;
        }

        System.out.println(res);
    }
}

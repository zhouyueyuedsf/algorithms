package company.sina;

import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Long> arrList = new ArrayList<>();
        String v = null;
        while (!(v = scanner.nextLine()).equals("")) {
            try {
                arrList.add(Long.valueOf(v));
            } catch (NumberFormatException e) {
                break;
            }
        }
        int len = arrList.size();
        Long[] arr = new Long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = arrList.get(i);
        }

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 0);
            }

        }
        int count = -1;
        Long max = Long.MIN_VALUE;
        Iterator<Entry<Long, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Long, Integer> entry = iter.next();
            if (entry.getValue() > count || (entry.getValue() == count && entry.getKey() > max)) {
                max = entry.getKey();
                count = entry.getValue();
            }
        }

        System.out.println("value = " + max + "\t" +"count = " + (count + 1));

    }

}

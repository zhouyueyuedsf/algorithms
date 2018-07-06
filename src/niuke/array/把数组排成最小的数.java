package niuke.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 把数组排成最小的数 {

    public  int compare(String a, String b) {
        if (Integer.parseInt(a + b) > Integer.parseInt(b + a)) {
            return 1;
        } else if (Integer.parseInt(a + b) < Integer.parseInt(b + a)) {
            return -1;
        } else {
            return 0;
        }
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null) return null;
        //转成字符串，然后排序，排序规则自定义
        int len = numbers.length;
        String[] strList = new String[len];
        for (int i = 0; i < len; i++) {
            strList[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String str :
                strList) {
            builder.append(str);
        }
        return builder.toString();
    }

    /**
     * 待解
     *
     * @param numbers
     */
    private void helper2(int[] numbers) {
        int len = numbers.length;
        List<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String str = String.valueOf(numbers[i]);
            int[] temp = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                temp[j] = str.charAt(j);
            }
            arrayList.add(temp);
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int temp = arrayList.get(i)[0];
            if (temp < min) {
                min = temp;
                index = i;
            } else if (temp == min) {
                int minArrayLen = arrayList.get(index).length;
                int curArrayLen = arrayList.get(i).length;
                if (minArrayLen < curArrayLen) {

                }
            }
        }
    }

    public static void main(String[] args) {
        把数组排成最小的数 run = new 把数组排成最小的数();
        System.out.println(run.PrintMinNumber(new int[]{3,32,321}));;
    }
}

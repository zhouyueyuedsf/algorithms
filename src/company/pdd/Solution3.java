package company.pdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();

        while(scanner.hasNext())
        {
            int a=scanner.nextInt();
            list.add(a);
        }

        int sum = 0;
        for(int i=0;i<=list.size();i++)
        {
            if(list.get(i)>1)
            {
                int v = list.get(i + 1) + list.get(i) / 2;
                list.set(i + 1, v);
                list.set(i, list.get(i) % 2);
            }
            if(list.get(i)==1)
            {
                sum++;
            }
        }
        System.out.println(sum);

    }

    private static int compare(int[] temp, int i, int[] max, int k) {
        int count = 0;
        for (int m = 0; m < temp.length; m++) {
            if (temp[m] < max[m]) {
                count++;
            }
        }
        if (count > temp.length / 2) {

            return i;
        } else {
            return -1;
        }
    }

}


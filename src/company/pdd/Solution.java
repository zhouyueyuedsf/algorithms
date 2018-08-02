package company.pdd;

import java.util.*;
public class Solution{
    public static String solution(int N){
        if(N == 0 )return null;
        ArrayList<String> list = new ArrayList<String>();
        list.add("Alice");
        list.add("Bob");
        list.add("Cathy");
        list.add("Dave");

        int v = 3;
        int max = 4;
        int temp = 0;
        while (max < N){
            temp = max;
            max = max + (int)Math.pow(2, v);
            v++;
        }

        int pa = (int)Math.pow(2, --v) / 4;

        int pos = (N - temp - 1) / pa;


        return list.get(pos);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(Solution.solution(N));
    }
}


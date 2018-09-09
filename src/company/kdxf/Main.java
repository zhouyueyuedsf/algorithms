package company.kdxf;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
//            String line = scanner.nextLine();
            int size = scanner.nextInt();
            int avg = scanner.nextInt();
            long needAllScore = size * avg;
            int[] scores = new int[size];
            long curAllScore = 0;
            for (int j = 0; j < size; j++) {
                scores[j] = scanner.nextInt();
                curAllScore += scores[j];
            }
            int res = 0;
            Arrays.sort(scores);
            if (needAllScore > curAllScore) {
                res++;
            }
            for (int score : scores) {
                curAllScore = curAllScore + (100 - score);
                if (needAllScore > curAllScore) {
                    res++;
                } else {
                    System.out.println(res);
                    break;
                };
            }
//            String line = scanner.nextLine();
        }
    }
}

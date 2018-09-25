package company.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static int kmp(String str, String dest, int[] next){//str文本串  dest 模式串
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return -1;
    }
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String P = scanner.nextLine();
        int[] next = kmpnext(P);
        int start = 0;
        int len = S.length();
        List<Integer> indexs = new ArrayList<>();

        int preStart = 0;
        int lenP = P.length();

        start = kmp(S, P, next);
        preStart = start;
        indexs.add(preStart);
        S = S.substring(start + lenP, len);
        len = S.length();
        while (start < len) {
            start = kmp(S, P, next);
            if (start == -1) {
                break;
            }
            preStart = lenP + preStart + start;
            indexs.add(preStart);
            S = S.substring(start + lenP, len);
            len = S.length();
        }
        int size = indexs.size();

        int res = 0;
        for (int i = 0; i < size; i++) {
            int cur = -1;
            int after = -1;
            cur = indexs.get(i);
            if (i + 1 < size) {
                after = indexs.get(i + 1);
            }

            if (after - cur == lenP) {
                res += (int) Math.pow(2, 2 * lenP);
            } else {
                res += Math.pow(2, lenP);
            }
        }
        System.out.println(res);
    }
}

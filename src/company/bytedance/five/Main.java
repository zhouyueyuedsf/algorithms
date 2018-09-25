package company.bytedance.five;

import java.util.Scanner;

public class Main {
    public static boolean exist(char[][] board, String word) {
        if(board==null)
            return false;
        boolean result = false;

        char[] input = word.toCharArray();
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m ;i++) {
            for(int j=0; j<n; j++) {
                if(helper(board,input,0,i,j))
                    result = true;
            }
        }
        return result;
    }

    public static boolean helper(char[][] board, char[] input, int idx, int i, int j) {

        if(i<0 || j<0 || i>=board.length || j>=board[0].length)
            return false;

        if(board[i][j] == input[idx]) {
            char temp = board[i][j];
            board[i][j] = '#';
            if(idx == input.length-1)
                return true;
            else if(helper(board, input, idx+1, i-1, j) || helper(board, input, idx+1, i+1, j)
                    || helper(board, input, idx+1, i, j-1) || helper(board, input, idx+1, i, j+1)){
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        String[] words = new String[K];
        scanner.nextLine();
        words = scanner.nextLine().split(" ");
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }

        for (String word : words) {
            char[][] temp = new char[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = board[i][j];
                }
            }
            if (exist(temp, word)){
                System.out.println(word);
            };
        }

    }
}

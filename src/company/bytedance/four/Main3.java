package company.bytedance.four;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        boolean board[][] = new boolean[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = scanner.nextInt() != 0;
            }
        }
        boolean visited[][] = new boolean[M][M];
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (i < M && j < M && board[i][j] && !visited[i][j]) {
                    dfs(board, M, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(boolean board[][], int M, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= M || j >= M) {
            return;
        }
        if (i < M && j < M) {
            if (!board[i][j] || visited[i][j]) {
                return;
            }
        }

        if (i < M && j < M) {
            visited[i][j] = true;
        }
        if (i < M - 1 && j < M) {
            dfs(board, M, i + 1, j, visited);
        }
        if (i > 0 && j < M) {
            dfs(board, M, i - 1, j, visited);
        }
        if (j > 0 && i < M) {
            dfs(board, M, i, j - 1, visited);
        }
        if (j < M - 1 && i < M) {
            dfs(board, M, i, j + 1, visited);
        }
    }

}
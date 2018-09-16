package company.bcz.one;

import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] word = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < str.length(); j++) {
                word[i][j] = str.charAt(j);
            }
        }
        char[] query = scanner.nextLine().toCharArray();
        System.out.println(search(word, query, m, n));
    }

    private static boolean search(char[][] matrix, char[] str, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == str[0] && !visited[i][j]) {
                    if (search(matrix, str, 0, visited, i, j, rows, cols)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean res = true;

    private static boolean search(char[][] word, char[] query, int index, boolean[][] visited,
                                  int i, int j, int m, int n) {

        if (!res) {
            return false;
        }

        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return true;
        }
        if (index >= query.length) {
            return true;
        }

        if (word[i][j] == query[index]) {
            visited[i][j] = true;
            return search(word, query, index + 1, visited, i + 1, j, m, n)
                    || search(word, query, index + 1, visited, i - 1, j, m, n)
                    || search(word, query, index + 1, visited, i, j - 1, m, n)
                    || search(word, query, index + 1, visited, i, j + 1, m, n);
        }
        res = false;
        return res;
    }
}

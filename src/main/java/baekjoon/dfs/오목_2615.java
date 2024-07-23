package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 오목_2615 {

    static int[] drow = {0, 1, 1, -1};
    static int[] dcol = {1, 1, 0, 1};
    static int result = 0;
    static int winRow = 0;
    static int winCol = 0;

    public static void searchStone(int[][] board, int row, int col, int color, int depth, int direction, boolean[][] check) {
        int nextRow = row + drow[direction];
        int nextCol = col + dcol[direction];
        if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length ||
                board[nextRow][nextCol] != color) {
            if (depth == 5) {
                result = color;
            }
            return;
        }

        check[nextRow][nextCol] = true;
        searchStone(board, nextRow, nextCol, color, depth + 1, direction, check);
    }

    private static void initCheck(boolean[][] check) {
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                check[i][j] = false;
            }
        }
    }

    public static void searchBoard(int[][] board, boolean[][] check) {
        for (int direction = 0; direction < 4; direction++) {

            initCheck(check);
            for (int col = 0; col < board.length; col++) {
                for (int row = 0; row < board[0].length; row++) {

                    int color = board[row][col];
                    if (color == 0 || check[row][col]) {
                        continue;
                    }

                    searchStone(board, row, col, board[row][col], 1, direction, check);

                    if (result != 0) {
                        winRow = row + 1;
                        winCol = col + 1;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] board = new int[19][19];
        boolean[][] check = new boolean[19][19];

        for (int row = 0; row < 19; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 19; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        searchBoard(board, check);

        bw.write(String.valueOf(result));
        if (result != 0) {
            bw.newLine();
            bw.write(winRow + " " + winCol);
        }
        bw.flush();
    }
}

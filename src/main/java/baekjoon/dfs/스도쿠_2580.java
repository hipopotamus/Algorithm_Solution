package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 스도쿠_2580 {

    public static boolean possibility(int[][] sudoku, int row, int col, int value) {

        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printResult(int[][] sudoku) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                sb.append(sudoku[rowIndex][colIndex]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        System.exit(0);
    }

    public static void solveSudoku(int[][] sudoku, int row, int col) throws IOException {
        if (col == sudoku[0].length) {
            solveSudoku(sudoku, row + 1, 0);
            return;
        }

        if (row == sudoku.length) {
            printResult(sudoku);
        }

        if (sudoku[row][col] == 0) {
            for (int value = 1; value <= sudoku.length; value++) {
                if (possibility(sudoku, row, col, value)) {
                    sudoku[row][col] = value;
                    solveSudoku(sudoku, row, col + 1);
                }
            }
            sudoku[row][col] =  0;
            return;
        }

        solveSudoku(sudoku, row, col + 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] sudoku = new int[9][9];

        for (int row = 0; row < 9; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 9; col++) {
                int number = Integer.parseInt(st.nextToken());
                sudoku[row][col] = number;
            }
        }

        solveSudoku(sudoku, 0, 0);
    }
}

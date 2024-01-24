package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 색종이_만들기_2630 {

    static int blueArea = 0;
    static int whiteArea = 0;

    static double[] dRow = {0, 0.5, 0, 0.5};
    static double[] dCol = {0, 0, 0.5, 0.5};

    private static int checkArea(int[][] colorPaper, int rowStart, int colStart, int size) {
        int blueCount = 0;
        int rowEnd = rowStart + size;
        int colEnd = colStart + size;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (colorPaper[i][j] == 1) {
                    blueCount++;
                }
            }
        }

        if (blueCount == size * size) {
            return 1;
        } else if (blueCount == 0) {
            return 2;
        }
        return 0;
    }

    private static void cutColorPaper(int[][] colorPaper, int row, int col, int size) {
        int checkResult = checkArea(colorPaper, row, col, size);
        if (checkResult == 1) {
            blueArea++;
            return;
        } else if (checkResult == 2) {
            whiteArea++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = (int) (row + dRow[i] * size);
            int nextCol = (int) (col + dCol[i] * size);

            cutColorPaper(colorPaper, nextRow, nextCol, (int) (size * 0.5));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[][] colorPaper = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                int color = Integer.parseInt(st.nextToken());
                colorPaper[i][j] = color;
            }
        }

        cutColorPaper(colorPaper, 0, 0, size);

        bw.write(String.format("%d\n%d", whiteArea, blueArea));
        bw.flush();
    }
}

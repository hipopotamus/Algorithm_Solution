package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Z_1074 {
    static int count = 0;

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    //행렬을 4등분 했을 때 target의 위치에 따라 찾을 영역을 줄여주는 메서드
    //줄여진 영역(target을 포함하는)의 시작점을 반환한다.
    public static Point reduceArea(int row, int col, int targetRow, int targetCol, int n) {
        int pow = (int) Math.pow(2, n - 1);
        int rowBoundary = row + pow;
        int colBoundary = col + pow;

        if (targetRow < rowBoundary && targetCol < colBoundary) {
            return new Point(row, col);
        }
        if (targetRow < rowBoundary) {
            count += pow * pow;
            return new Point(row, colBoundary);
        }
        if (targetCol < colBoundary) {
            count += 2 * pow * pow;
            return new Point(rowBoundary, col);
        }
        count += 3 * pow * pow;
        return new Point(rowBoundary, colBoundary);
    }

    //영역을 2^n-1 x 2^n-1 씩 줄여가며 재귀적으로 target을 찾는 메서드
    public static void searchTargetByRecursion(int n, int row, int col, int targetRow, int targetCol) {
        if (row == targetRow && col == targetCol) {
            return;
        }

        Point nextPoint = reduceArea(row, col, targetRow, targetCol, n);
        searchTargetByRecursion(n - 1, nextPoint.row, nextPoint.col, targetRow, targetCol);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int targetRow = Integer.parseInt(st.nextToken());
        int targetCol = Integer.parseInt(st.nextToken());

        searchTargetByRecursion(n, 0, 0, targetRow, targetCol);

        bw.write(String.valueOf(count));
        bw.flush();
    }
}

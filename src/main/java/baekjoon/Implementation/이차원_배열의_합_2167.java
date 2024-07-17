package baekjoon.Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class 이차원_배열의_합_2167 {

    public static int subSumOfArray(int[][] array, int startRow, int startCol, int endRow, int endCol) {
        int sum = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] array = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int number = Integer.parseInt(st.nextToken());
                array[i][j] = number;
            }
        }

        int caseSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());

            int subSum = subSumOfArray(array, startRow - 1, startCol - 1, endRow - 1, endCol - 1);
            bw.write(String.valueOf(subSum));
            bw.newLine();
        }

        bw.flush();
    }
}

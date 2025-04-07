package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_5_11660 {
    public static int calculateRangeSum(int[][] prefixSumMatrix, int row1, int col1, int row2, int col2) {

        int sum = prefixSumMatrix[row2][col2];

        if (row1 - 1 > 0) {
            sum -= prefixSumMatrix[row1 - 1][col2];
        }

        if (col1 - 1 > 0) {
            sum -= prefixSumMatrix[row2][col1 - 1];
        }

        if (row1 - 1 > 0 && col1 - 1 > 0) {
            sum += prefixSumMatrix[row1 - 1][col1 - 1];
        }

        return sum;
    }

    public static int[][] buildPrefixSumMatrix(int size, int[][] matrix) {
        int[][] prefixSumMatrix = new int[size][size];

        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                prefixSumMatrix[row][col] = prefixSumMatrix[row - 1][col] + prefixSumMatrix[row][col - 1] - prefixSumMatrix[row - 1][col - 1]
                        + matrix[row][col];
            }
        }

        return prefixSumMatrix;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int size = Integer.parseInt(st.nextToken());
        int caseSize = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[size + 1][size + 1];

        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= size; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] prefixSumMatrix = buildPrefixSumMatrix(size + 1, matrix);

        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            long result = calculateRangeSum(prefixSumMatrix, row1, col1, row2, col2);

            System.out.println(result);
        }
    }
}

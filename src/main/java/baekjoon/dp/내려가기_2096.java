package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096 {

    public static void initMemoTable(int[][] numberTable, int[][] maxMemoTable, int[][] minMemoTable) {

        System.arraycopy(numberTable[0], 0, maxMemoTable[0], 1, numberTable[0].length);
        System.arraycopy(numberTable[0], 0, minMemoTable[0], 1, numberTable[0].length);

        for (int row = 1; row < numberTable.length; row++) {
            for (int col = 1; col < numberTable[row].length + 1; col++) {
                maxMemoTable[row][col] = Math.max(maxMemoTable[row - 1][col - 1],
                        Math.max(maxMemoTable[row - 1][col], maxMemoTable[row - 1][col + 1])) + numberTable[row][col - 1];
                minMemoTable[row][col] = Math.min(minMemoTable[row - 1][col - 1],
                        Math.min(minMemoTable[row - 1][col], minMemoTable[row - 1][col + 1])) + numberTable[row][col - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] numberTable = new int[size][3];
        int[][] maxMemoTable = new int[size][5];
        int[][] minMemoTable = new int[size][5];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                numberTable[i][j] = Integer.parseInt(st.nextToken());
            }
            minMemoTable[i][0] = 10000000;
            minMemoTable[i][4] = 10000000;
        }

        initMemoTable(numberTable, maxMemoTable, minMemoTable);

        System.out.printf("%d %d",
                Math.max(maxMemoTable[size - 1][1], Math.max(maxMemoTable[size - 1][2], maxMemoTable[size - 1][3])),
                Math.min(minMemoTable[size - 1][1], Math.min(minMemoTable[size - 1][2], minMemoTable[size - 1][3])));
    }
}

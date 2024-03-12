package baekjoon.dfs;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리_1149 {

    private static int getMinCostByDp(int[][] costArr, int size) {
        int[][] memorization = new int[size][3];

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                memorization[i][j] =
                        costArr[i][j] + Math.min(memorization[i - 1][(j + 1) % 3], memorization[i - 1][(j + 2) % 3]);
            }
        }

        return Arrays.stream(memorization[size - 1]).min().getAsInt();
    }

    private static void initCostArr(int size, BufferedReader br, int[][] costArr) throws IOException {
        StringTokenizer st;
        for (int i = 1; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                costArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[][] costArr = new int[size + 1][3];

        initCostArr(size + 1, br, costArr);

        int result = getMinCostByDp(costArr, size + 1);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

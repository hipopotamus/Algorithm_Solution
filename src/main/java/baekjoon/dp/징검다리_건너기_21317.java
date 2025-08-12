package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리_건너기_21317 {

    public static int minDistance(int[][] memorization, int[] smallJumpCost, int[] bigJumpCost, int biggestJumpCost) {

        for (int i = 0; i < memorization.length; i++) {
            for (int j = 1; j < memorization[0].length; j++) {
                if (j == (i + 3)) {
                    memorization[i][j] = memorization[i][j - 3] + biggestJumpCost;
                    continue;
                }
                if (j == 1) {
                    memorization[i][j] = memorization[i][j - 1] + smallJumpCost[j - 1];
                    continue;
                }
                memorization[i][j] = Math.min((memorization[i][j - 1] + smallJumpCost[j - 1]), (memorization[i][j - 2] + bigJumpCost[j - 2]));
            }
        }

        return Arrays.stream(memorization)
                .mapToInt(row -> row[row.length - 1])
                .min()
                .orElseThrow();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] memorization = new int[size][size];
        int[] smallJumpCost = new int[size - 1];
        int[] bigJumpCost = new int[size - 1];

        StringTokenizer st;
        for (int i = 0; i < size - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            smallJumpCost[i] = Integer.parseInt(st.nextToken());
            bigJumpCost[i] = Integer.parseInt(st.nextToken());
        }

        int biggestJumpCost = Integer.parseInt(br.readLine());

        int minDistance = minDistance(memorization, smallJumpCost, bigJumpCost, biggestJumpCost);

        System.out.println(minDistance);
    }
}

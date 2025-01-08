package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAZE_RUNNER_16720 {

    public static int getRoadIndex(String row) {
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == '0') {
                return i;
            }
        }
        return -1;
    }

    public static int minMatchCase(int[] roadSequence) {
        int minMatchCount = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int matchCount = 0;
            for (int j = 0; j < roadSequence.length; j++) {
                int count = Math.abs(i - roadSequence[j]);
                if (count == 3) {
                    count = 1;
                }
                matchCount += count;
            }

            if (matchCount < minMatchCount) {
                minMatchCount = matchCount;
            }
        }

        return minMatchCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] roadSequence = new int[size - 2];

        for (int i = 0; i < size - 2; i++) {
            String roadInfo = br.readLine();

            int roadIndex = getRoadIndex(roadInfo);
            roadSequence[i] = roadIndex;
        }

        int minCount = minMatchCase(roadSequence) + size + 2;

        System.out.println(minCount);
    }
}

package codingtest.showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 문제3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int satisfactionSize = Integer.parseInt(st.nextToken());
        int personalitySize = Math.max(rowSize, colSize);
        long result = 0;

        long[][] memorization = new long[rowSize + 1][colSize + 1];
        int[][] personalityArr = new int[3][personalitySize + 1];
        long[][] satisfactionArr = new long[satisfactionSize + 1][satisfactionSize + 1];

        for (int i = 1; i <= satisfactionSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= satisfactionSize; j++) {
                satisfactionArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= rowSize; i++) {
            personalityArr[1][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= colSize; i++) {
            personalityArr[2][i] = Integer.parseInt(st.nextToken());
        }

        memorization[1][1] = satisfactionArr[personalityArr[1][1]][personalityArr[2][1]];

        for (int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= colSize; j++) {
                memorization[i][j] = Math.min(memorization[i - 1][j], memorization[i][j - 1])
                        + satisfactionArr[personalityArr[1][i]][personalityArr[2][j]];
            }
        }

        for (long[] ints : memorization) {
            long max = Arrays.stream(ints).max().getAsLong();
            if (max > result) {
                result = max;
            }
        }

        System.out.println(result);
    }
}

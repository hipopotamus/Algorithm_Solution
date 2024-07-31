package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상자넣기_1965 {

    public static int getMaxBox(int[] sequence) {
        int[] memorization = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            memorization[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && memorization[i] - 1 < memorization[j]) {
                    memorization[i] = memorization[j] + 1;
                }
            }
        }

        return Arrays.stream(memorization)
                .max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxBoxCount = getMaxBox(sequence);

        System.out.println(maxBoxCount);
    }
}

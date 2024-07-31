package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장_큰_증가하는_부분수열_11055 {

    public static int getMaxValue(int[] sequence) {
        int[] memorization = new int[sequence.length];

        for (int i = 0; i < memorization.length; i++) {
            memorization[i] = sequence[i];
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && (memorization[i] - sequence[i]) < memorization[j]) {
                    memorization[i] = memorization[j] + sequence[i];
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

        int maxValue = getMaxValue(sequence);

        System.out.println(maxValue);
    }
}

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장_큰_증가하는_부분수열_11055 {

    //memorization[i] = i번째 숫자가 부분수열의 마지막이 될 때 될 수 있는 가장 큰 중가하는 부분수열의 합
    //memorization[i] = memorization[j] + i번째 숫자 (i번째 숫자 > j번째 숫자를 만족하는 j중 가장 최대값(max(memorization[j])))
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

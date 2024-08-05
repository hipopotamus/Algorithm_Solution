package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상자넣기_1965 {

    //가장 긴 증가하는 부분 수열
    //memorization[i] = i번째 숫자가 부분수열의 마지막이 될 때, 될 수 있는 가장 긴 증가하는 부분수열의 개수
    //memorization[i] = memorization[j] + 1 (i번째 숫자 > j번째 숫자를 만족하는 j중 가장 최대값(max(memorization[j])))
    public static int getMaxBox(int[] sequence) {
        int[] memorization = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            memorization[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && memorization[i] < memorization[j] + 1) {
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

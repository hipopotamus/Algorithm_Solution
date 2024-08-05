package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_긴_감소하는_부분_수열_11722 {

    //memorization[i] = i번째 숫자가 부분수열의 마지막이 될 때, 될 수 있는 가장 긴 감소하는 부분수열의 개수
    //memorization[i] = memorization[j] + 1 (j번째 숫자 > i번째 숫자를 만족하는 j중 가장 최대값(max(memorization[j])))
    private static int getMaxValue(int[] sequence) {
        int[] memorization = new int[sequence.length];

        for (int i = 1; i <= memorization.length; i++) {
            memorization[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (sequence[i] < sequence[j] && memorization[i] < memorization[j] + 1) {
                    memorization[i] = memorization[j] + 1;
                }
            }
        }

        return Arrays.stream(memorization)
                .max().getAsInt();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        int[] sequence = new int[size + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= size; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int result = getMaxValue(sequence);

        System.out.println(result);
    }
}

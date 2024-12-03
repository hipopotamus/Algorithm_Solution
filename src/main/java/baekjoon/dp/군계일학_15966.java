package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 군계일학_15966 {

    public static int excludeSequence(int[] memorization, int[] numbers) {

        for (int i = 0; i < memorization.length; i++) {
            memorization[i] = 1;

            for (int j = 0; j < i; j++) {
                if (numbers[j] + 1 == numbers[i] && memorization[j] + 1 >= memorization[i]) {
                    memorization[i] = memorization[j] + 1;
                }
            }
        }

        return Arrays.stream(memorization).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] memorization = new int[size];
        int[] numbers = new int[size];

        String[] numberInfo = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(numberInfo[i]);
        }

        int result = excludeSequence(memorization, numbers);

        System.out.println(result);
    }
}

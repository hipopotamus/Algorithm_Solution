package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 민균이의_계략_11568 {

    public static int getMaxIncreaseSequenceCount(int[] sequence) {
        int[] memorization = new int[sequence.length];
        Arrays.fill(memorization, 1);
        int maxCount = 1;

        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && memorization[i] < memorization[j] + 1) {
                    memorization[i] = memorization[j] + 1;
                    if (maxCount < memorization[i]) {
                        maxCount = memorization[i];
                    }
                }
            }
        }

        return maxCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] sequence = new int[size];

        String[] numberInfo = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            sequence[i] = Integer.parseInt(numberInfo[i]);
        }

        int maxCount = getMaxIncreaseSequenceCount(sequence);

        System.out.println(maxCount);
    }
}

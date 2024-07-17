package baekjoon.twofactor;

import java.io.*;

public class 수들의_합_5_2018 {
    public static int numberOfCaseByTwoFactor(int target, int[] sequence) {
        int left = 0;
        int right = 0;
        int subSum = sequence[0];
        int count = 0;

        while (right < sequence.length) {
            if (subSum == target) {
                count++;
            }
            if (subSum <= target) {
                if (right == sequence.length - 1) {
                    break;
                }
                subSum += sequence[++right];
            } else if (subSum > target) {
                subSum -= sequence[left++];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = Integer.parseInt(br.readLine());

        int[] sequence = new int[target];

        for (int i = 0; i < target; i++) {
            sequence[i] = i + 1;
        }

        int numberOfCase = numberOfCaseByTwoFactor(target, sequence);

        bw.write(String.valueOf(numberOfCase));
        bw.flush();
    }
}

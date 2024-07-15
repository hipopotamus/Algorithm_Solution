package baekjoon.dp;

import java.io.*;

public class Four_Square_17626 {

    public static int lagrangeMethod(int number) {
        int[] solutionArr = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            solutionArr[i] = Integer.MAX_VALUE;
        }

        solutionArr[0] = 0;

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j * j <= i; j++) {
                solutionArr[i] = Math.min(solutionArr[i], solutionArr[i - j * j] + 1);
            }
        }

        return solutionArr[number];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        int lagrangeNumber = lagrangeMethod(size);

        bw.write(String.valueOf(lagrangeNumber));
        bw.flush();
    }
}

package baekjoon.math;

import java.io.*;

public class 파도반_수열_9461 {

    private static long calculateSequence(int n, long[] sequence) {
        return sequence[n - 5] + sequence[n - 1];
    }

    private static void setSequence(long[] sequence) {
        sequence[1] = 1;
        sequence[2] = 1;
        sequence[3] = 1;
        sequence[4] = 2;
        sequence[5] = 2;

        for (int i = 6; i < sequence.length; i++) {
            sequence[i] = calculateSequence(i, sequence);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] sequence = new long[101];
        setSequence(sequence);

        int caseSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseSize; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(sequence[n]));
            bw.newLine();
        }

        bw.flush();
    }
}

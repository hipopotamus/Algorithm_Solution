package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_4_15652 {

    public static void printCombination(int N, int M, int depth, int number, int[] sequence) {
        sequence[depth] = number;

        if (depth == M) {
            for (int i = 1; i < sequence.length; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = sequence[depth]; i <= N; i++) {
            if (i == 0) {
                continue;
            }
            printCombination(N, M, depth + 1, i, sequence);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        printCombination(N, M, 0, 0, new int[M + 1]);
    }
}

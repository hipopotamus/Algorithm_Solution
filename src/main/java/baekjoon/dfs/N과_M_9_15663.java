package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_9_15663 {
    public static void printSequence(int N, int M, int depth, int index, int[] sequence, int[] numbers,
                                     boolean[] visited) {
        sequence[depth] = numbers[index];
        visited[index] = true;

        if (depth == M) {
            for (int i = 1; i < sequence.length; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        boolean[] visitedByDepth = new boolean[100001];
        for (int i = 1; i <= N; i++) {
            if (visited[i] || visitedByDepth[numbers[i]]) {
                continue;
            }
            visitedByDepth[numbers[i]] = true;
            printSequence(N, M, depth + 1, i, sequence, numbers, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        int[] sequence = new int[M + 1];
        boolean[] visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        printSequence(N, M, 0, 0, sequence, numbers, visited);
    }
}

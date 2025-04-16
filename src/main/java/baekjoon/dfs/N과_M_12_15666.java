package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N과_M_12_15666 {

    public static void printSequence(int M, int depth, int index, int[] sequence, ArrayList<Integer> numbers) {
        sequence[depth] = numbers.get(index);

        if (depth == M) {
            for (int i = 1; i < sequence.length; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < numbers.size(); i++) {
            if (sequence[depth] > numbers.get(i)) {
                continue;
            }

            printSequence(M, depth + 1, i, sequence, numbers);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> numberSet = new HashSet<>();
        int[] sequence = new int[M + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            numberSet.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> numbers = new ArrayList<>(numberSet);
        numbers.add(0, 0);
        numbers.sort(Comparator.naturalOrder());

        printSequence(M, 0, 0, sequence, numbers);
    }
}

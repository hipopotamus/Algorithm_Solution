package baekjoon.twofactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class List_of_Unique_Numbers_13144 {

    public static long searchUniqueSequence(int[] sequence, boolean[] check) {
        long result = 0;
        int left = 0;
        int right = 0;

        check[sequence[0]] = true;

        while (left < sequence.length) {
            while (right < sequence.length - 1  && !check[sequence[right + 1]]) {
                right++;
                check[sequence[right]] = true;
            }

            result += right - left + 1;

            check[sequence[left]] = false;
            left++;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] sequence = new int[size];
        boolean[] check = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        long result = searchUniqueSequence(sequence, check);

        System.out.println(result);
    }
}

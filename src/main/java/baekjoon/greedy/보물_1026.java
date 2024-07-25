package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 보물_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int sum = 0;
        int size = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[size];
        Integer[] B = new Integer[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(st.nextToken());
            A[i] = number;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(st.nextToken());
            B[i] = number;
        }

        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        for (int i = 0; i < size; i++) {
            sum += A[i] * B[i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}

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

        //입력 시작
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
        //입력 끝

        //A를 내림차순으로, B를 오름차순으로 정렬
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);

        for (int i = 0; i < size; i++) {
            sum += A[i] * B[i];
        }

        //출력
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}

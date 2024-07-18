package baekjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class 알고리즘_수업_점근적_표기_1_24313 {

    public static int validateInequality(int a1, int a0, int c, int n0) {
        if (a1 > c) {
            return 0;
        }
        if (a1 * n0 + a0 <= c * n0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int result = validateInequality(a1, a0, c, n0);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

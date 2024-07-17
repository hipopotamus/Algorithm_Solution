package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class 마인크래프트_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxHeight = 0;

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int box = Integer.parseInt(st.nextToken());

        int[][] blocks = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}

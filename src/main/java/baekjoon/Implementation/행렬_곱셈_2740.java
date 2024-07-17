package baekjoon.Implementation;

import java.io.*;
import java.util.StringTokenizer;

public class 행렬_곱셈_2740 {

    public static int[][] multiplyArray(int[][] array1, int[][] array2) {

        int[][] result = new int[array1.length][array2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < array1[0].length; k++) {
                    sum += array1[i][k] * array2[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row1 = Integer.parseInt(st.nextToken());
        int col1 = Integer.parseInt(st.nextToken());
        int[][] array1 = new int[row1][col1];

        for (int i = 0; i < row1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col1; j++) {
                array1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int row2 = Integer.parseInt(st.nextToken());
        int col2 = Integer.parseInt(st.nextToken());
        int[][] array2 = new int[row2][col2];

        for (int i = 0; i < row2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col2; j++) {
                array2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = multiplyArray(array1, array2);

        for (int[] elements : result) {
            for (int element : elements) {
                bw.write(element + " ");
            }
            bw.newLine();
        }

        bw.flush();

    }
}

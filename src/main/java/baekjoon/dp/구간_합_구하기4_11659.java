package baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기4_11659 {

    private static int[] calculateCumulativeSumArray(int[] numberArr) {
        int[] cumulativeSumArr = new int[numberArr.length];
        cumulativeSumArr[0] = numberArr[0];

        for (int i = 1; i < cumulativeSumArr.length; i++) {
            cumulativeSumArr[i] = cumulativeSumArr[i - 1] + numberArr[i];
        }

        return cumulativeSumArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sizeEnum = new StringTokenizer(br.readLine(), " ");
        int arrSize = Integer.parseInt(sizeEnum.nextToken());
        int size = Integer.parseInt(sizeEnum.nextToken());

        int[] numberArr = new int[arrSize + 1];
        StringTokenizer numberEnum = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < numberArr.length; i++) {
            numberArr[i] = Integer.parseInt(numberEnum.nextToken());
        }

        int[] cumulativeSumArr = calculateCumulativeSumArray(numberArr);

        for (int i = 0; i < size; i++) {
            StringTokenizer intervalEnum = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(intervalEnum.nextToken());
            int end = Integer.parseInt(intervalEnum.nextToken());

            int cumulativeSum = cumulativeSumArr[end] - cumulativeSumArr[start - 1];
            bw.write(String.valueOf(cumulativeSum));
            bw.newLine();
        }

        bw.flush();
    }
}

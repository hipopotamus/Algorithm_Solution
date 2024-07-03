package baekjoon.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전0_11047 {

    public static int calculateCoinMin(Integer[] coin, int target) {

        int count = 0;

        for (int value : coin) {
            int quotient = target / value;
            if (quotient > 0) {
                target -= value * quotient;
                count += quotient;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int coinSize = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Integer[] coinArr = new Integer[coinSize];

        for (int i = 0; i < coinSize; i++) {
            int coin = Integer.parseInt(br.readLine());
            coinArr[i] = coin;
        }

        Arrays.sort(coinArr, Collections.reverseOrder());

        int min = calculateCoinMin(coinArr, target);

        bw.write(String.valueOf(min));
        bw.flush();

    }
}

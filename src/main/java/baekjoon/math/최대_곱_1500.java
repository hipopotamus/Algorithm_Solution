package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 최대_곱_1500 {

    public static BigInteger calculateMaxMultiple(int s, int k) {
        int base = s / k;
        int remainder = s - (base * k);
        BigInteger result = BigInteger.ONE;

        for (int i = 0; i < k; i++) {
            int value = base;
            if (remainder > 0) {
                value += 1;
                remainder--;
            }

            result = result.multiply(BigInteger.valueOf(value));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        BigInteger result = calculateMaxMultiple(s, k);

        System.out.println(result);
    }
}

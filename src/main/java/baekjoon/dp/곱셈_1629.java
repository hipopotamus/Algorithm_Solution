package baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class 곱셈_1629 {

    private static Long exponentiation(long number, long power, long remainder) {
        if (power == 1) {
            return number % remainder;
        }

        long dividedPower = (power / 2);
        long dividedResult = exponentiation(number, dividedPower, remainder);
        long result = ((dividedResult % remainder) * (dividedResult % remainder)) % remainder;
        if (power % 2 == 1) {
            return (result * (number % remainder)) % remainder;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long number = Long.parseLong(st.nextToken());
        long power = Long.parseLong(st.nextToken());
        long remainder = Long.parseLong(st.nextToken());

        long result = exponentiation(number, power, remainder);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

package baekjoon.math;

import java.io.*;
import java.math.BigInteger;

public class 홀짝_11834 {

    public static BigInteger findOddEvenOrder(BigInteger number) {
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.valueOf(10).pow(100);
        BigInteger mid = BigInteger.ZERO;
        BigInteger solution = BigInteger.ZERO;

        while (left.compareTo(right) <= 0) {
            mid = left.add(right).divide(BigInteger.TWO);
            BigInteger target = mid.multiply(mid.add(BigInteger.ONE)).divide(BigInteger.TWO);

            if (target.compareTo(number) == 0) {
                solution = mid;
                break;
            }
            if (target.compareTo(number) < 0) {
                left = mid.add(BigInteger.ONE);
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
        }
        if (solution.compareTo(BigInteger.ZERO) == 0) {
            solution = left;
        }

        return number.multiply(BigInteger.TWO).subtract(solution);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger number = new BigInteger(br.readLine());
        BigInteger oddEvenOrder = findOddEvenOrder(number);

        bw.write(oddEvenOrder.toString());
        bw.flush();
    }
}

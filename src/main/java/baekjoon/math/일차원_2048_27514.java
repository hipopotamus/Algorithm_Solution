package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일차원_2048_27514 {

    public static int logTwo(long number) {
        return (int) (Math.log(number) / Math.log(2));
    }

    public static int getLargest(int[] exponents) {
        for (int i = exponents.length - 1; i >= 0; i--) {
            if (exponents[i] != 0) {
                return i;
            }
        }
        return 0;
    }

    public static void makeSequence(int[] exponents, int exponent) {
        if (exponents[exponent] == 0) {
            exponents[exponent] = 1;
        } else if (exponents[exponent] == 1) {
            exponents[exponent] = 0;
            makeSequence(exponents, exponent + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] exponents = new int[63];

        String[] numbers = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            long number = Long.parseLong(numbers[i]);

            if (number == 0) {
                continue;
            }

            int exponent = logTwo(number);
            makeSequence(exponents, exponent);
        }

        int largestExponent = getLargest(exponents);

        System.out.println((long) Math.pow(2, largestExponent));
    }
}

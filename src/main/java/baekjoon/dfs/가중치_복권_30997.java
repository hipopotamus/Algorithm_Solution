package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 가중치_복권_30997 {

    public static Fraction maxProbability;
    public static int[] maxNumbers;

    public static class Fraction {
        private BigInteger numerator;
        private BigInteger denominator;

        public Fraction(BigInteger numerator, BigInteger denominator) {
            if (denominator.equals(0)) {
                throw new IllegalArgumentException();
            }

            BigInteger gcd = numerator.gcd(denominator);
            this.numerator = numerator.divide(gcd);
            this.denominator = denominator.divide(gcd);
        }

        public Fraction multiply(Fraction other) {
            return new Fraction(
                    this.numerator.multiply(other.numerator),
                    this.denominator.multiply(other.denominator)
            );
        }

        public boolean isBig(Fraction other) {
            BigInteger numerator = this.numerator.multiply(other.denominator);
            BigInteger otherNumerator = other.numerator.multiply(this.denominator);

            return numerator.compareTo(otherNumerator) >= 0;
        }
    }

    public static void combination(int[] p, int[] numbers, int depth, int index, int peopleSize, int k) {
        if (depth == 3) {
            int numerator = p[numbers[0]] + p[numbers[1]] + p[numbers[2]] + 3;
            int denominator = peopleSize * 3;
            Fraction fraction = new Fraction(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
            Fraction other = new Fraction(BigInteger.valueOf(denominator - numerator), BigInteger.valueOf(denominator));

            Fraction probability = new Fraction(BigInteger.valueOf(denominator - numerator), BigInteger.valueOf(denominator));
            for (int i = 0; i < k - 1; i++) {
                probability = probability.multiply(other);
            }
            probability = probability.multiply(fraction);

            if (maxProbability == null || probability.isBig(maxProbability)) {
                maxProbability = new Fraction(probability.numerator, probability.denominator);
                maxNumbers = new int[]{numbers[0], numbers[1], numbers[2]};
            }
            return;
        }

        for (int i = 1; i < p.length; i++) {
            if (i <= index) {
                continue;
            }
            index = i;
            numbers[depth] = i;

            combination(p, numbers, depth + 1, index, peopleSize, k);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberSize = Integer.parseInt(st.nextToken());
        int peopleSize = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] p = new int[numberSize + 1];
        int[] numbers = new int[3];

        for (int i = 0; i < peopleSize - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());

            p[one] = p[one] + 1;
            p[two] = p[two] + 1;
            p[three] = p[three] + 1;
        }

        combination(p, numbers, 0, 0, peopleSize, k);

        System.out.printf("%s %s%n", maxProbability.numerator.toString(), maxProbability.denominator.toString());
        System.out.printf("%d %d %d", maxNumbers[0], maxNumbers[1], maxNumbers[2]);
    }
}

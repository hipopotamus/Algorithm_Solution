package baekjoon.dfs;

import java.io.*;
import java.math.BigInteger;

public class 하노이_탑_1914 {

    public static void solveHanoiRecursively(int n, int startIndex, int voidIndex, int endIndex, StringBuilder sb) {
        if (n == 1) {
            sb.append(startIndex).append(" ").append(endIndex).append("\n");
            return;
        }

        solveHanoiRecursively(n - 1, startIndex, endIndex, voidIndex, sb);
        sb.append(startIndex).append(" ").append(endIndex).append("\n");
        solveHanoiRecursively(n - 1, voidIndex, startIndex, endIndex, sb);
    }

    public static BigInteger solutionOfHanoiCase(int n) {
        BigInteger caseOfNumber = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            caseOfNumber = caseOfNumber.multiply(BigInteger.TWO).add(BigInteger.ONE);
        }
        return caseOfNumber;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());

        BigInteger numberOfCase = solutionOfHanoiCase(number);
        bw.write(numberOfCase.toString());
        bw.newLine();

        if (number <= 20) {
            solveHanoiRecursively(number, 1, 2, 3, sb);
            bw.write(sb.toString());
        }

        bw.flush();
    }
}

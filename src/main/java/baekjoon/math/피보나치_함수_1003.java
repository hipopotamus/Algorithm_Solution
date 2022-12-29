package baekjoon.math;

import java.io.*;

public class 피보나치_함수_1003 {

    public static class FibonacciCount {

        FibonacciCount(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }

        int zeroCount = 0;
        int oneCount = 0;
    }

    private static void initFibonacci(FibonacciCount[] fibonacciArr) {
        fibonacciArr[0] = new FibonacciCount(1, 0);
        fibonacciArr[1] = new FibonacciCount(0, 1);
        for (int i = 2; i < fibonacciArr.length; i++) {
            fibonacciArr[i] =
                    new FibonacciCount(fibonacciArr[i - 1].zeroCount + fibonacciArr[i - 2].zeroCount,
                            fibonacciArr[i - 1].oneCount + fibonacciArr[i - 2].oneCount);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        FibonacciCount[] fibonacciArr = new FibonacciCount[41];
        initFibonacci(fibonacciArr);

        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(String.format("%d %d\n", fibonacciArr[n].zeroCount, fibonacciArr[n].oneCount));
        }

        bw.flush();
    }
}

package baekjoon.math;

import java.io.*;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 삼십_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //0이 없을 경우 30의 배수가 될수 없기 때문에 이를 판단하는 플래그를 생성
        //가장 큰 수 를 만들어야되기 때문에 우선순위 큐 사용
        String number = br.readLine();
        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.reverseOrder());
        boolean zeroFlag = false;
        long sumOfDigits = 0;
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            if (digit == '0') {
                zeroFlag = true;
            }

            queue.offer(digit);

            sumOfDigits += Integer.parseInt(String.valueOf(digit));
        }

        //0이 없거나 3의 배수가 아닐 경우 -1을 반환
        //30의 배수라면 가장 큰 수 부터 출력
        if (!zeroFlag || sumOfDigits % 3 != 0) {
            result = BigInteger.valueOf(-1);
        } else {
            StringBuilder multiplyOfThirty = new StringBuilder();
            while (!queue.isEmpty()) {
                Character ch = queue.poll();
                multiplyOfThirty.append(ch);
            }

            result = new BigInteger(multiplyOfThirty.toString());
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

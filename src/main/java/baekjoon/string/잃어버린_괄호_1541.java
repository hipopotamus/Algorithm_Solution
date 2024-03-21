package baekjoon.string;

import java.io.*;

public class 잃어버린_괄호_1541 {

    private static int searchMinimumByParentheses(String expression) {
        int plusSum = 0;
        int minusSum = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c != '-' && c != '+' && i != expression.length() - 1) {
                sb.append(c);
            } else {
                if (i == expression.length() - 1) {
                    sb.append(c);
                }

                int number = Integer.parseInt(sb.toString());
                sb.setLength(0);

                if (flag) {
                    plusSum += number;
                } else {
                    minusSum += number;
                }

                if (c == '-' && flag) {
                    flag = false;
                }
            }
        }

        return plusSum - minusSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = br.readLine();

        int result = searchMinimumByParentheses(expression);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

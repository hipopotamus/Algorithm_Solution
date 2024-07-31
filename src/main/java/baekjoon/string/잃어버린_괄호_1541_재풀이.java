package baekjoon.string;

import java.io.*;

public class 잃어버린_괄호_1541_재풀이 {

    //최소값이 되도록 연산을하는 메서드
    //빼기가 나오면 그 뒤의 숫자는 다 빼준다.
    public static int applyBrackets(String equation) {
        StringBuilder numberSet = new StringBuilder();
        //빼기가 나왔는지 판단하는 플래그
        boolean minusFlag = false;
        int sum = 0;

        for (int i = 0; i < equation.length(); i++) {
            char character = equation.charAt(i);

            if (character != '-' && character != '+' && i != equation.length() - 1) {
                numberSet.append(character);
            } else {
                if (i == equation.length() - 1) {
                    numberSet.append(character);
                }

                int number = Integer.parseInt(numberSet.toString());
                numberSet.setLength(0);

                if (!minusFlag) {
                    sum += number;
                } else {
                    sum -= number;
                }

                if (character == '-') {
                    minusFlag = true;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String equation = br.readLine();

        int min = applyBrackets(equation);

        bw.write(String.valueOf(min));
        bw.flush();
    }
}

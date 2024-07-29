package baekjoon.tree;

import java.io.*;
import java.util.StringTokenizer;

public class 삼십번_13116 {

    //공통된 부모를 찾는 메서드
    //부모 노드의 숫자 = 현재 노드의 숫자 / 2
    //숫자가 더 큰 노드의 부모를 찾고 숫자가 같아질 때 까지 이를 반복한다
    public static int findParent(int number1, int number2) {
        while (number1 != number2) {
            if (number1 > number2) {
                number1 /= 2;
            }
            if (number1 < number2) {
                number2 /= 2;
            }
        }

        return number1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =  new StringBuilder();

        int caseSize = Integer.parseInt(br.readLine());

        while (caseSize-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());

            int result = findParent(number1, number2) * 10;
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

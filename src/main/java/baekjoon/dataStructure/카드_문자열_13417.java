package baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 카드_문자열_13417 {

    public static String getMinLexString(String[] alphabetArr) {
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new LinkedList<>();

        deque.add(alphabetArr[0]);

        for (int i = 1; i < alphabetArr.length; i++) {
            String alphabet = alphabetArr[i];
            String firstAlphabet = deque.peek();

            if (alphabet.compareTo(firstAlphabet) <= 0) {
                deque.addFirst(alphabet);
            } else {
                deque.addLast(alphabet);
            }
        }

        for (String alphabet : deque) {
            sb.append(alphabet);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseSize = Integer.parseInt(br.readLine());
        while (caseSize-- > 0) {
            br.readLine();
            String[] alphabetArr = br.readLine().split(" ");
            String minLexString = getMinLexString(alphabetArr);

            sb.append(minLexString).append("\n");
        }

        System.out.println(sb);
    }
}

package baekjoon.dataStructure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class PPAP_16120 {

    public static String validatePPAPString(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (character == 'P') {
                deque.addFirst(character);
                count++;
                continue;
            }
            if (character == 'A' && count >= 2 && i != str.length() - 1 && str.charAt(i + 1) == 'P') {
                deque.removeFirst();
                deque.removeFirst();
                count -= 2;
                continue;
            }
            return "NP";
        }
        if (deque.size() == 1) {
            return "PPAP";
        }
        return "NP";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        String answer = validatePPAPString(str);

        bw.write(answer);
        bw.flush();
    }
}

package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서_검색_1543 {

    public static int countWord(String word, String target) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < target.length() && i + j < word.length(); j++) {
                if (word.charAt(i + j) != target.charAt(j)) {
                    break;
                }
                if (j == target.length() - 1) {
                    i = i + j;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String target = br.readLine();

        int count = countWord(word, target);

        System.out.println(count);
    }
}

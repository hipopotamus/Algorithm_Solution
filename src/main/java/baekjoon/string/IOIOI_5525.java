package baekjoon.string;

import java.io.*;

public class IOIOI_5525 {

    private static void calculateP(int[] p, String word) {
        int j = 0;
        for (int i = 1; i < word.length(); i++) {
            while (j > 0 && word.charAt(i) != word.charAt(j)) {
                j = p[j - 1];
            }
            if (word.charAt(i) == word.charAt(j)) {
                p[i] = ++j;
            }
        }
    }

    private static int countWordByKMP(int[] p, String sentence, String word) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < sentence.length(); i++) {
            while (j > 0 && sentence.charAt(i) != word.charAt(j)) {
                j = p[j - 1];
            }
            if (sentence.charAt(i) == word.charAt(j)) {
                if (j == word.length() - 1) {
                    count++;
                    j = p[j];
                } else {
                    j++;
                }
            }
        }

        return count;
    }

    private static String createWord(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('I');
        for (int i = 0; i < n; i++) {
            sb.append("OI");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String word = createWord(n);

        int sentenceLength = Integer.parseInt(br.readLine());
        String sentence = br.readLine();

        int[] p = new int[word.length()];
        calculateP(p, word);

        int count = countWordByKMP(p, sentence, word);

        bw.write(String.valueOf(count));
        bw.flush();
    }
}

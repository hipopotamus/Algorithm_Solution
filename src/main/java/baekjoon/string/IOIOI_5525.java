package baekjoon.string;

import java.io.*;

public class IOIOI_5525 {

    private static void calculateP(int[] p, String target) {
        int j = 0;
        for (int i = 1; i < target.length(); i++) {
            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = p[j - 1];
            }
            if (target.charAt(i) == target.charAt(j)) {
                p[i] = ++j;
            }
        }
    }

    private static int countWordByKMP(int[] p, String string, String target) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < string.length(); i++) {
            while (j > 0 && string.charAt(i) != target.charAt(j)) {
                j = p[j - 1];
            }
            if (string.charAt(i) == target.charAt(j)) {
                if (j == target.length() - 1) {
                    count++;
                    j = p[j];
                } else {
                    j++;
                }
            }
        }

        return count;
    }

    private static String createIO(int n) {
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
        String word = createIO(n);

        int sentenceLength = Integer.parseInt(br.readLine());
        String sentence = br.readLine();

        int[] p = new int[word.length()];
        calculateP(p, word);

        int count = countWordByKMP(p, sentence, word);

        bw.write(String.valueOf(count));
        bw.flush();
    }
}

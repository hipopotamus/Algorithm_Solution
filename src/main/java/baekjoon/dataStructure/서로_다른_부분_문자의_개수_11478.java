package baekjoon.dataStructure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 서로_다른_부분_문자의_개수_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Set<String> subStringSet = new HashSet<>();

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            sb.setLength(0);
            sb.append(word.charAt(i));
            subStringSet.add(sb.toString());
            for (int j = i + 1; j < word.length(); j++) {
                sb.append(word.charAt(j));
                subStringSet.add(sb.toString());
            }
        }

        bw.write(String.valueOf(subStringSet.size()));
        bw.flush();
    }
}

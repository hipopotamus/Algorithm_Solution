package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 단어_정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Set<String> wordSet = new HashSet<>();

        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            wordSet.add(br.readLine());
        }

        List<String> wordList = new ArrayList<>(wordSet);
        wordList.sort(Comparator.naturalOrder());
        wordList.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        for (String word : wordList) {
            sb.append(word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

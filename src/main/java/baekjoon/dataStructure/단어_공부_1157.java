package baekjoon.dataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 단어_공부_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> alphabetMap = new HashMap<>();

        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            char upperAlphabet = Character.toUpperCase(alphabet);
            alphabetMap.put(upperAlphabet, alphabetMap.getOrDefault(upperAlphabet, 0) + 1);
        }

        Integer maxValue = alphabetMap.values().stream()
                .max(Integer::compareTo).get();

        List<Character> maxValueAlphabetList = alphabetMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (maxValueAlphabetList.size() == 1) {
            bw.write(String.valueOf(maxValueAlphabetList.get(0)));
        } else if (maxValueAlphabetList.size() > 1) {
            bw.write("?");
        }

        bw.flush();
    }
}

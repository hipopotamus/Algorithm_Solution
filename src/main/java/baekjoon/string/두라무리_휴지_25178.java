package baekjoon.string;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 두라무리_휴지_25178 {

    private static boolean isNotVowel(Character character) {
        return character != 'a' && character != 'e' && character != 'i'
                && character != 'o' && character != 'u';
    }

    //두라무리를 판단하는 메서드
    public static String validateDuramuri(String string1, String string2) {
        Map<Character, Integer> characterMap = new HashMap<>();
        StringBuilder strWithoutVowels1 = new StringBuilder();
        StringBuilder strWithoutVowels2 = new StringBuilder();

        for (int i = 0; i < string1.length(); i++) {
            characterMap.put(string1.charAt(i), characterMap.getOrDefault(string1.charAt(i), 0) + 1);

            if (isNotVowel(string1.charAt(i))) {
                strWithoutVowels1.append(string1.charAt(i));
            }
            if (isNotVowel(string2.charAt(i))) {
                strWithoutVowels2.append(string2.charAt(i));
            }
        }

        for (int i = 0; i < string2.length(); i++) {
            characterMap.put(string2.charAt(i), characterMap.getOrDefault(string2.charAt(i), 0) - 1);
        }

        //문자의 개수가 일치하지 않을 경우
        for (Integer count : characterMap.values()) {
            if (count != 0) {
                return "NO";
            }
        }

        //앞글자와 뒷글자가 틀릴경우
        if (string1.charAt(0) != string2.charAt(0) ||
                string1.charAt(string1.length() - 1) != string2.charAt(string2.length() - 1)) {
            return "NO";
        }

        //모음을 뺀 문자열이 일치하지 않을 경우
        if (!strWithoutVowels1.toString().equals(strWithoutVowels2.toString())) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String string1 = br.readLine();
        String string2 = br.readLine();

        String result = validateDuramuri(string1, string2);

        bw.write(result);
        bw.flush();
    }
}

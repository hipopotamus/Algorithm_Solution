package baekjoon.math;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕_신혜빈_9357_다른풀이 {

    private static Map<String, Integer> getCostumeMap(BufferedReader br) throws IOException {
        StringTokenizer st;
        Map<String, Integer> costumeMap = new HashMap<>();

        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String costume = st.nextToken();
            costumeMap.put(costume, costumeMap.getOrDefault(costume, 0) + 1);
        }

        return costumeMap;
    }

    private static int calculateNumberOfCase(Map<String, Integer> costumeMap) {

        int numberOfCase = 1;

        if (costumeMap.isEmpty()) {
            return 0;
        }

        for (Map.Entry<String, Integer> entry : costumeMap.entrySet()) {
            numberOfCase *= entry.getValue() + 1;
        }

        return numberOfCase - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseSize; i++) {
            Map<String, Integer> costumeMap = getCostumeMap(br);
            int numberOfCase = calculateNumberOfCase(costumeMap);
            bw.write(String.valueOf(numberOfCase));
            bw.newLine();
        }

        bw.flush();
    }
}

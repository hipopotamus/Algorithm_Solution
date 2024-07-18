package baekjoon.dataStructure;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 회사에_있는_사람_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Map<String, String> accessMap = new HashMap<>();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            accessMap.put(name, status);
        }

        List<String> enterPeopleList = accessMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals("enter"))
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for (String name : enterPeopleList) {
            bw.write(name);
            bw.newLine();
        }

        bw.flush();
    }
}

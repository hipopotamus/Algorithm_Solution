package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 듣보잡_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> nameMap = new HashMap<>();
        ArrayList<String> bastardList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int unHeardSize = Integer.parseInt(st.nextToken());
        int unSeenSize = Integer.parseInt(st.nextToken());

        for (int i = 0; i < unHeardSize; i++) {
            String name = br.readLine();
            nameMap.put(name, "unHeard");
        }

        for (int j = 0; j < unSeenSize; j++) {
            String name = br.readLine();
            String status = nameMap.get(name);
            if (status == null) {
                continue;
            }
            bastardList.add(name);
        }

        bastardList.sort(Comparator.naturalOrder());

        bw.write(String.valueOf(bastardList.size()));
        bw.newLine();

        bastardList.forEach(bastard -> {
            try {
                bw.write(bastard + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
    }
}

package baekjoon.dataStructure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 인사성_밝은_곰곰_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> bearChatCountSet = new HashSet<>();
        int count = 0;

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String log = br.readLine();

            if (log.equals("ENTER")) {
                count += bearChatCountSet.size();
                bearChatCountSet.clear();
            } else {
                bearChatCountSet.add(log);
            }

        }
        count += bearChatCountSet.size();

        bw.write(String.valueOf(count));
        bw.flush();
    }
}

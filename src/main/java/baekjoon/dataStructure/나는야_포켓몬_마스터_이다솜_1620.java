package baekjoon.dataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> pocketMonMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int pocketMonSize = Integer.parseInt(st.nextToken());
        int answerSize = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= pocketMonSize; i++) {
            String pocketMon = br.readLine();
            pocketMonMap.put(String.valueOf(i), pocketMon);
            pocketMonMap.put(pocketMon, String.valueOf(i));
        }

        for (int j = 0; j < answerSize; j++) {
            String pocketMon = br.readLine();
            String answer = pocketMonMap.get(pocketMon);
            bw.write(answer);
            bw.newLine();
        }
        bw.flush();
    }
}

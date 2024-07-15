package baekjoon.dataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호_찾기_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> sitePasswordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalSize = Integer.parseInt(st.nextToken());
        int searchSize = Integer.parseInt(st.nextToken());

        for (int i = 0; i < totalSize; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();

            sitePasswordMap.put(site, password);
        }

        for (int i = 0; i < searchSize; i++) {
            String searchSite = br.readLine();
            bw.write(sitePasswordMap.get(searchSite));
            bw.newLine();
        }

        bw.flush();
    }
}

package baekjoon.dataStructure;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class 파일_정리_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> extensionMap = new TreeMap<>();

        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String filename = br.readLine();
            String extension = filename.substring(filename.lastIndexOf(".") + 1);
            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry :extensionMap.entrySet()) {
            bw.write(String.format("%s %d\n", entry.getKey(), entry.getValue()));
        }
        bw.flush();
    }
}

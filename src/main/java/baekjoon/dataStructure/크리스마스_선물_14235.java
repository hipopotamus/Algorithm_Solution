package baekjoon.dataStructure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스_선물_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 0) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
                continue;
            }
            
            for (int j = 0; j < command; j++) {
                int presentValue = Integer.parseInt(st.nextToken());
                queue.add(presentValue);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

package baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이중_우선순위_큐_7662 {

    static Map<Integer, Integer> countMap;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < testSize; i++) {
            int size = Integer.parseInt(br.readLine());

            Queue<Integer> minQueue = new PriorityQueue<>();
            Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            countMap = new HashMap<>(); //각 queue에서 숫자의 위치 파악

            for (int j = 0; j < size; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String commend = st.nextToken();

                if (commend.equals("I")) {
                    int number = Integer.parseInt(st.nextToken());
                    maxQueue.add(number);
                    minQueue.add(number);
                    countMap.put(number, countMap.getOrDefault(number, 0)+1);//queue에 없으면 0, 있으면 개수
                } else {
                    int type = Integer.parseInt(st.nextToken());

                    if (countMap.isEmpty()) {
                        continue;
                    }
                    if (type == 1) {
                        poll(maxQueue);
                    } else {
                        poll(minQueue);
                    }
                }
            }

            if (countMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                int res = poll(maxQueue);
                sb.append(res).append(" ");
                if (!countMap.isEmpty()) {
                    res = poll(minQueue);
                }
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int poll(Queue<Integer> q) {
        int res = 0;
        while (true) {
            res = q.poll();
            int cnt = countMap.getOrDefault(res, 0);
            if (cnt == 0) {
                continue;
            }
            if (cnt == 1) {
                countMap.remove(res);
            } else {
                countMap.put(res, cnt-1);
            }
            break;
        }

        return res;
    }
}
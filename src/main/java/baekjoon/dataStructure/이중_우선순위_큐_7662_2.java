package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 이중_우선순위_큐_7662_2 {

    public static class DualPriorityQueue{
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQueue = new PriorityQueue<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        public void add(int number) {
            maxQueue.add(number);
            minQueue.add(number);
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        private int poll(Queue<Integer> queue) {
            int result = 0;

            while (true) {
                Integer number = queue.poll();
                Integer count = countMap.getOrDefault(number, 0);

                if (count == 0) {
                    continue;
                }
                if (count == 1) {
                    countMap.remove(number);
                } else {
                    countMap.put(number, count - 1);
                }
                result = number;
                break;

            }

            return result;
        }

        public int pollMax() {
            return poll(maxQueue);
        }

        public int pollMin() {
            return poll(minQueue);
        }

        public boolean isEmpty() {
            return countMap.isEmpty();
        }
    }

    public static void calculateQueue(DualPriorityQueue queue, String command, int number) {
        switch (command) {
            case "I" :
                queue.add(number);
                break;
            case "D" :
                if (queue.isEmpty()) {
                    return;
                }
                if (number == 1) {
                    queue.pollMax();
                } else if (number == -1) {
                    queue.pollMin();
                }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < testSize; i++) {
            int size = Integer.parseInt(br.readLine());

            DualPriorityQueue queue = new DualPriorityQueue();

            for (int j = 0; j < size; j++) {
                //입력
                StringTokenizer st = new StringTokenizer(br.readLine());
                String commend = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                //로직
                calculateQueue(queue, commend, number);
            }

            //출력
            if (queue.isEmpty()) {
                bw.write("EMPTY");
            } else {
                int result = queue.pollMax();
                bw.write(String.format("%d ", result));
                if (!queue.isEmpty()) {
                    result = queue.pollMin();
                }
                bw.write(String.format("%d", result));
            }
            bw.flush();
            bw.newLine();
        }
    }
}
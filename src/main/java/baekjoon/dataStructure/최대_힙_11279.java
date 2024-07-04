package baekjoon.dataStructure;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 최대_힙_11279 {

    public static class MaxPriorityQueue {
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        public void add(int number) {
            maxQueue.add(number);
        }

        public int poll() {
            if (maxQueue.isEmpty()) {
                return 0;
            }

            return maxQueue.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                int maxNumber = maxPriorityQueue.poll();
                bw.write(maxNumber + "\n");
            } else {
                maxPriorityQueue.add(command);
            }
        }
        bw.flush();
    }
}

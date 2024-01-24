package baekjoon.dataStructure;

import java.io.*;
import java.util.PriorityQueue;

public class 최소_힙_1927 {

    private static int pollQueue(PriorityQueue<Integer> queue) {
        Integer number = queue.poll();
        if (number == null) {
            return 0;
        }
        return number;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                int n = pollQueue(queue);
                bw.write(String.valueOf(n));
                bw.newLine();
            } else {
                queue.offer(number);
            }
        }

        bw.flush();
    }
}

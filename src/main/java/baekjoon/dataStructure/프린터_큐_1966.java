package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 프린터_큐_1966 {

    public static class IndexedNumber {
        int number;
        int index;

        public IndexedNumber(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int caseSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseSize; i++) {
            PriorityQueue<IndexedNumber> priorityQueue = new PriorityQueue<>((n1, n2) -> Integer.compare(n2.number, n1.number));
            Queue<IndexedNumber> queue = new LinkedList<>();
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < size; index++) {
                int number = Integer.parseInt(st.nextToken());
                IndexedNumber indexedNumber = new IndexedNumber(number, index);
                priorityQueue.add(indexedNumber);
                queue.add(indexedNumber);
            }

            while (true) {
                IndexedNumber indexIndexedNumber = queue.poll();
                IndexedNumber priorityIndexedNumber = priorityQueue.peek();

                if (indexIndexedNumber.number < priorityIndexedNumber.number) {
                    queue.add(indexIndexedNumber);
                }
                if (indexIndexedNumber.number == priorityIndexedNumber.number) {
                    priorityQueue.poll();
                    count++;
                    if (indexIndexedNumber.index == targetIndex) {
                        break;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

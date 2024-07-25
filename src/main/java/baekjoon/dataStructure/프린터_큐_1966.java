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

    private static int countOrder(Queue<IndexedNumber> queue, PriorityQueue<IndexedNumber> priorityQueue, int count,
                                  int targetIndex) {

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
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int caseSize = Integer.parseInt(br.readLine());

        //입력 시작
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
        //입력 끝

            count = countOrder(queue, priorityQueue, count, targetIndex);

            sb.append(count).append("\n");
        }

        //출력
        bw.write(sb.toString());
        bw.flush();
    }
}

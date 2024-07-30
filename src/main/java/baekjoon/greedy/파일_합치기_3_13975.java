package baekjoon.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일_합치기_3_13975 {
    public static long sumFile(PriorityQueue<Long> queue) {
        long sum = 0;

        while(queue.size() != 1) {
            Long firstNumber = queue.poll();
            Long secondNumber = queue.poll();
            long price = firstNumber + secondNumber;
            sum += price;

            queue.offer(price);
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long caseSize = Long.parseLong(br.readLine());

        while (caseSize-- > 0) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            long size = Long.parseLong(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (long i = 0; i < size; i++) {
                long number = Long.parseLong(st.nextToken());
                queue.offer(number);
            }

            long result = sumFile(queue);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

package baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class 요세푸스_문제_1158 {

    private static void fillSequence(int size, int target, List<Integer> sequence) {
        Queue<Integer> mainQueue = new LinkedList<>();
        Queue<Integer> subQueue = new LinkedList<>();
        Queue<Integer> tempQueue;
        int count = 0;

        for (int i = 1; i <= size; i++) {
            mainQueue.offer(i);
        }

        while (!mainQueue.isEmpty() || !subQueue.isEmpty()) {
            if (mainQueue.isEmpty()) {
                tempQueue = mainQueue;
                mainQueue = subQueue;
                subQueue = tempQueue;
            }

            Integer number = mainQueue.poll();
            count++;

            if (count == target) {
                count = 0;
                sequence.add(number);
            } else {
                subQueue.add(number);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> sequence = new ArrayList<>();

        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        fillSequence(size, target, sequence);

        sb.append('<');
        for (int i = 0; i < sequence.size(); i++) {
            sb.append(sequence.get(i));
            if (i != sequence.size() - 1) {
                sb.append(", ");
            } else {
                sb.append('>');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

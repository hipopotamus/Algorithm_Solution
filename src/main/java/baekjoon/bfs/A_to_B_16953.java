package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A_to_B_16953 {

    public static class Number {
        long number;
        int distance = 1;

        public long doubleTime() {
            return number * 2;
        }

        public long insertOne() {
            return (number * 10) + 1;
        }

        public Number(long number) {
            this.number = number;
        }
    }

    private static void nextNode(long target, Set<Long> check, long doubleTime, Queue<Number> queue, Number number) {
        if (doubleTime <= target && !check.contains(doubleTime)) {
            Number nextNode = new Number(doubleTime);
            nextNode.distance = number.distance + 1;
            queue.offer(nextNode);
            check.add(doubleTime);
        }
    }

    public static int getMinCalculate(long target, Set<Long> check, Number initNumber) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(initNumber);
        check.add(initNumber.number);

        while (!queue.isEmpty()) {
            Number number = queue.poll();

            if (number.number == target) {
                return number.distance;
            }

            long doubleTime = number.doubleTime();
            long insertOne = number.insertOne();

            nextNode(target, check, doubleTime, queue, number);
            nextNode(target, check, insertOne, queue, number);
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        Set<Long> check = new HashSet<>();

        int result = getMinCalculate(B, check, new Number(A));

        System.out.println(result);
    }
}

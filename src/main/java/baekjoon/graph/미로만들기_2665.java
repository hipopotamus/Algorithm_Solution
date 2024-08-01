package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 미로만들기_2665 {

    public static class Node {
        //payoff -> 0 = 흰색, 1 = 검정색
        int row;
        int col;
        int payoff;
        int totalPayoff = Integer.MAX_VALUE;
        boolean visited = false;

        public Node(int row, int col, int payoff) {
            this.row = row;
            this.col = col;
            this.payoff = payoff;
        }
    }

    public static void getMinPayoff(Node[][] map) {
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.totalPayoff));

        Node firstNode = map[0][0];
        firstNode.totalPayoff = 0;
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.visited) {
                continue;
            }
            node.visited = true;

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dRow[i];
                int nextCol = node.col + dCol[i];
                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length) {
                    continue;
                }

                Node nextNode = map[nextRow][nextCol];
                if (nextNode.totalPayoff > node.totalPayoff + nextNode.payoff) {
                    nextNode.totalPayoff = node.totalPayoff + nextNode.payoff;
                    queue.offer(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        Node[][] map = new Node[size][size];
        for (int row = 0; row < size; row++) {
            String inputRow = br.readLine();
            for (int col = 0; col < size; col++) {
                //0 -> 1으로 1 -> 0으로 변경
                int payoff = ((inputRow.charAt(col) - '0') + 1) % 2;
                map[row][col] = new Node(row, col, payoff);
            }
        }

        getMinPayoff(map);

        System.out.println(map[size - 1][size - 1].totalPayoff);
    }
}

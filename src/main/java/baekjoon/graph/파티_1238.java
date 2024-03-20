package baekjoon.graph;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {

    public static class Node{
        boolean check = false;
        int totalPayoff = 0;
        int[] payoff;

        public Node(int[] payoff) {
            this.payoff = payoff;
        }
    }


    private static int[] calculateMinimumCostByDijkstra(Node[] nodeArr, Node startNode) {
        int[] totalPayoffArr = Arrays.copyOf(startNode.payoff, startNode.payoff.length);

        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.totalPayoff < n2.totalPayoff ? -1 : 1);
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.check) {
                continue;
            }
            node.check = true;
            int[] payoffArr = node.payoff;

            for (int i = 0; i < nodeArr.length; i++) {
                Node nextNode = nodeArr[i];
                int payoff = payoffArr[i];
                int totalPayoff = node.totalPayoff + payoff;
                if ((payoff == Integer.MAX_VALUE) || (totalPayoff > totalPayoffArr[i])) {
                    continue;
                }

                nextNode.totalPayoff = totalPayoff;
                totalPayoffArr[i] = totalPayoff;
                queue.offer(nextNode);
            }
        }
        return totalPayoffArr;
    }

    private static void initNodeArr(Node[] nodeArr) {
        for (Node node : nodeArr) {
            node.totalPayoff = 0;
            node.check = false;
        }
    }

    private static void initArrays(int[][] payOffArr, int edgeSize, BufferedReader br, Node[] nodeArr) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < payOffArr.length; i++) {
            Arrays.fill(payOffArr[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            payOffArr[from][to] = cost;
        }

        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(payOffArr[i]);
        }
    }

    private static int getMinimumCostFromStartNode(int nodeSize, int startNodeNumber, int[][] memorization, int result) {
        for (int i = 0; i < nodeSize; i++) {
            if (i == startNodeNumber - 1) {
                continue;
            }
            int totalCost = memorization[i][startNodeNumber - 1] + memorization[startNodeNumber - 1][i];
            if (totalCost > result) {
                result = totalCost;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int startNodeNumber = Integer.parseInt(st.nextToken());

        int[][] payOffArr = new int[nodeSize][nodeSize];
        int[][] memorization = new int[nodeSize][nodeSize];
        Node[] nodeArr = new Node[nodeSize];
        int result = 0;

        initArrays(payOffArr, edgeSize, br, nodeArr);

        for (int i = 0; i < nodeSize; i++) {
            int[] payoffArr = calculateMinimumCostByDijkstra(nodeArr, nodeArr[i]);
            initNodeArr(nodeArr);
            memorization[i] = payoffArr;
        }

        result = getMinimumCostFromStartNode(nodeSize, startNodeNumber, memorization, result);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

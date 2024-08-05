package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 택배_배송_5972 {

    //간선 클래스, 가중치를 필드로 갖음
    public static class Edge {
        Node toNode;
        int payoff;

        public Edge(Node toNode, int payoff) {
            this.toNode = toNode;
            this.payoff = payoff;
        }
    }

    //totalPayOff = 특정 노드로 부터 최단거리
    public static class Node {
        int totalPayOff = Integer.MAX_VALUE;
        boolean isVisited = false;
        List<Edge> edges = new ArrayList<>();

        public Node() {}
    }

    //다익스트라로 firstNode부터 최소 거리를 찾는 메서드
    public static void calculateMinPath(Node firstNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.totalPayOff, n2.totalPayOff));
        firstNode.totalPayOff = 0;
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.isVisited) {
                continue;
            }
            node.isVisited = true;

            for (Edge edge : node.edges) {
                Node nextNode = edge.toNode;

                if (nextNode.totalPayOff > node.totalPayOff + edge.payoff) {
                    nextNode.totalPayOff = node.totalPayOff + edge.payoff;
                }

                queue.offer(nextNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = br.readLine().split(" ");
        int size = Integer.parseInt(inputSize[0]);
        int edgeSize = Integer.parseInt(inputSize[1]);

        Node[] nodes = new Node[size + 1];
        for (int i = 0; i < size + 1; i++) {
            nodes[i] = new Node();
        }

        //** 입력 시작
        for (int i = 0; i < edgeSize; i++) {
            String[] edgeInput = br.readLine().split(" ");
            int from = Integer.parseInt(edgeInput[0]);
            int to = Integer.parseInt(edgeInput[1]);
            int payoff = Integer.parseInt(edgeInput[2]);

            nodes[from].edges.add(new Edge(nodes[to], payoff));
            nodes[to].edges.add(new Edge(nodes[from], payoff));
        }
        //** 입력 끝

        calculateMinPath(nodes[1]);

        int minPayoff = nodes[nodes.length - 1].totalPayOff;

        System.out.println(minPayoff);
    }
}

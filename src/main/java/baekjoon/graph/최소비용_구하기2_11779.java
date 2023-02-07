package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용_구하기2_11779 {

    private static class Edge {
        Node toNode;
        int payOff;

        public Edge(Node toNode, int payOff) {
            this.toNode = toNode;
            this.payOff = payOff;
        }
    }

    private static class Node {
        int number;
        int totalPayOff = Integer.MAX_VALUE;
        boolean check = false;
        List<Edge> edgeList = new ArrayList<>();
        List<Integer> route = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public void addRoute(List<Integer> route) {
            this.route = new ArrayList<>();
            this.route.addAll(route);
        }
    }

    private static void dijkstra(Node from) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.payOff - e2.payOff);
        queue.offer(new Edge(from, 0));

        while (!queue.isEmpty()) {
            Edge totalPayOffEdge = queue.poll();
            Node currentNode = totalPayOffEdge.toNode;

            if (currentNode.check) {
                continue;
            }
            currentNode.check = true;

            for (Edge edge : currentNode.edgeList) {
                Node nextNode = edge.toNode;

                int totalPayOff = currentNode.totalPayOff + edge.payOff;
                if (nextNode.totalPayOff < totalPayOff) {
                    continue;
                }
                nextNode.totalPayOff = totalPayOff;
                nextNode.addRoute(currentNode.route);
                nextNode.route.add(currentNode.number);

                queue.offer(new Edge(nextNode, nextNode.totalPayOff));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int edgeSize = Integer.parseInt(st.nextToken());

        Node[] nodeArr = new Node[nodeSize + 1];

        for (int i = 1; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeArr[from].edgeList.add(new Edge(nodeArr[to], cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        nodeArr[from].totalPayOff = 0;
        dijkstra(nodeArr[from]);

        nodeArr[to].route.add(nodeArr[to].number);
        System.out.println(nodeArr[to].totalPayOff);
        System.out.println(nodeArr[to].route.size());
        for (Integer integer : nodeArr[to].route) {
            System.out.print(integer +  " ");
        }
    }
}

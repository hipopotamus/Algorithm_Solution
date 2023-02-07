package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 타임머신 {

    private static class Node {
        int number;
        int totalPayOff = Integer.MAX_VALUE;
        boolean check = false;

        Map<Integer, Integer> edgeMap = new HashMap<>();

        public Node(int number) {
            this.number = number;
        }
    }

    private static boolean dynamic(PriorityQueue<Node> queue, Node[] nodeArr) {

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            currentNode.check = true;

            Map<Integer, Integer> edgeMap = currentNode.edgeMap;
            for (Integer nodeNumber : edgeMap.keySet()) {
                Node nextNode = nodeArr[nodeNumber];

                Integer cost = edgeMap.get(nodeNumber);
                int totalPayOff = currentNode.totalPayOff + cost;

                if (nextNode.totalPayOff <= totalPayOff) {
                    continue;
                }

                nextNode.totalPayOff = totalPayOff;

                Integer startCost = nextNode.edgeMap.get(1);
                if (startCost != null && nextNode.totalPayOff + startCost < 0) {
                    return false;
                }

                if (nextNode.check) {
                    continue;
                }

                queue.offer(nextNode);
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        Node[] nodeArr = new Node[nodeSize + 1];
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.totalPayOff - n2.totalPayOff);

        for (int i = 1; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeArr[from].edgeMap.put(to, cost);
        }

        queue.offer(nodeArr[1]);
        nodeArr[1].totalPayOff = 0;
        if (dynamic(queue, nodeArr)) {
            for (int i = 2; i < nodeArr.length; i++) {
                Node node = nodeArr[i];
                if (node.totalPayOff == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(node.totalPayOff);
                }
            }
        } else {
            System.out.println(-1);
        }
    }
}

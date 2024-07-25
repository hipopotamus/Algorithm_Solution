package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class 특정_거리의_도시_찾기_18352 {

    public static class Node {
        int number;
        int dist = 0;
        boolean isVisited = false;
        List<Node> edgeList = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }
    }

    public static List<Node> findNodesInRange(Node firstNode, int targetRange) {
        List<Node> nodesInRange = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        firstNode.isVisited = true;
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.dist == targetRange) {
                nodesInRange.add(node);
                continue;
            }

            for (Node nextNode : node.edgeList) {
                if (nextNode.isVisited) {
                    continue;
                }

                nextNode.isVisited = true;
                nextNode.dist += node.dist + 1;
                queue.offer(nextNode);
            }
        }

        nodesInRange.sort((n1, n2) -> Integer.compare(n1.number, n2.number));
        return nodesInRange;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int targetRange = Integer.parseInt(st.nextToken());
        int firstNodeNumber = Integer.parseInt(st.nextToken());

        Node[] nodeArr = new Node[nodeSize + 1];
        for (int i = 1; i <= nodeSize; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodeArr[from].edgeList.add(nodeArr[to]);
        }

        List<Node> nodesInRange = findNodesInRange(nodeArr[firstNodeNumber], targetRange);

        if (nodesInRange.isEmpty()) {
            sb.append(-1);
        } else {
            nodesInRange.forEach(node -> sb.append(node.number).append("\n"));
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거리_k이하인_트리_노드에서_사과_수확하기_25516 {

    public static class Node {
        int apple;
        int distance = 0;

        List<Node> children = new ArrayList<>();

        public Node() {
        }
    }

    public static int harvestApples(Node[] nodes, int maxDistance) {
        int totalApples = 0;
        Queue<Node> queue = new LinkedList<>();

        Node startNode = nodes[0];
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            totalApples += currentNode.apple;

            for (Node child : currentNode.children) {
                child.distance += currentNode.distance + 1;

                if (child.distance > maxDistance) {
                    continue;
                }

                queue.offer(child);
            }
        }

        return totalApples;
    }

    private static void init(int size, Node[] nodes, BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < size - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(st.nextToken());
            int childNodeNumber = Integer.parseInt(st.nextToken());

            nodes[nodeNumber].children.add(nodes[childNodeNumber]);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            nodes[i].apple = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int maxDistance = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[size];

        init(size, nodes, br);

        int totalApples = harvestApples(nodes, maxDistance);

        System.out.println(totalApples);
    }
}

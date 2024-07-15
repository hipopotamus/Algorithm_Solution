package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class 경로_찾기_11403 {

    public static class Node {
        int number;
        boolean visited = false;
        List<Node> toNodes = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public void initVisited() {
            this.visited = false;
        }
    }

    public static Node[] initNodeArr(int size) {
        Node[] nodeArr = new Node[size];
        for (int i = 0; i < size; i++) {
            nodeArr[i] = new Node(i);
        }

        return nodeArr;
    }

    public static void bfs(Node root, int[][] pathStatusArr) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int rootNumber = root.number;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node nextNode : node.toNodes) {
                if (nextNode.visited) {
                    continue;
                }
                nextNode.visited = true;
                pathStatusArr[rootNumber][nextNode.number] = 1;
                queue.offer(nextNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());

        int[][] pathStatusArr = new int[size][size];
        Node[] nodeArr = initNodeArr(size);

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == 1) {
                    nodeArr[i].toNodes.add(nodeArr[j]);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            Arrays.stream(nodeArr)
                    .forEach(Node::initVisited);

            bfs(nodeArr[i], pathStatusArr);
        }

        for (int i = 0; i < pathStatusArr.length; i++) {
            for (int j = 0; j < pathStatusArr[0].length; j++) {
                bw.write(pathStatusArr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}

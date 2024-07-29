package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class 바이러스_2606 {

    public static class Node {
        boolean check = false;
        List<Node> edge = new ArrayList<>();

        public Node() {}
    }

    private static int getInfectionNumber(Node firstNode) {
        int infectionCount = 0;
        Queue<Node> queue = new LinkedList<>();

        firstNode.check = true;
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node edgeNode : node.edge) {
                if (edgeNode.check) {
                    continue;
                }
                edgeNode.check = true;
                infectionCount++;
                queue.offer(edgeNode);
            }
        }

        return infectionCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //** 입력 시작
        int nodeSize = Integer.parseInt(br.readLine());

        Node[] nodeArr = new Node[nodeSize + 1];
        for (int i = 1; i <= nodeSize; i++) {
            nodeArr[i] = new Node();
        }

        int edgeSize = Integer.parseInt(br.readLine());
        for (int i = 0; i < edgeSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodeArr[from].edge.add(nodeArr[to]);
            nodeArr[to].edge.add(nodeArr[from]);
        }
        //** 입력 끝

        //바이러스에 감염된 컴퓨터의 수를 구함
        int infectionNumber = getInfectionNumber(nodeArr[1]);

        //-- 출력
        bw.write(String.valueOf(infectionNumber));
        bw.flush();
    }
}

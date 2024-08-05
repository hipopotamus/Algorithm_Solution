package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회장뽑기_2660 {

    public static class Node {
        int number;
        int score = Integer.MAX_VALUE;
        int distance = 0;
        boolean isVisited = false;
        List<Node> edgeList = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }
    }

    //그래프 상 firstNode 에서 가장 멀리 떨어진 노드의 거리 = 친구 점수
    //bfs로 firstNode 에서 가장 멀리 떨어진 노드의 거리를 찾고 기록
    public static void calculateFriendScore(Node firstNode) {
        Queue<Node> queue = new LinkedList<>();

        firstNode.isVisited = true;
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node nextNode : node.edgeList) {
                if (nextNode.isVisited) {
                    continue;
                }
                nextNode.isVisited = true;
                nextNode.distance = node.distance + 1;
                queue.offer(nextNode);
            }

            //bfs 탐색 마지막 노드 = fristNode에서 가장 멀리 떨어진 노드
            if (queue.isEmpty()) {
                firstNode.score = node.distance;
            }
        }
    }

    //회장인 노드를 추출하는 메서드
    public static Node[] filterPresident(Node[] nodes) {
        int minScore = Arrays.stream(nodes)
                .mapToInt(n -> n.score)
                .min().getAsInt();

        Node[] presidents = Arrays.stream(nodes)
                .filter(n -> n.score == minScore)
                .toArray(Node[]::new);

        return presidents;
    }

    public static void initNodes(Node[] nodes) {
        for (Node node : nodes) {
            node.isVisited = false;
            node.distance = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[size + 1];

        for (int i = 0; i < size + 1; i++) {
            nodes[i] = new Node(i);
        }

        //** 입력 시작
        while (true) {
            String[] inputEdge = br.readLine().split(" ");
            int from = Integer.parseInt(inputEdge[0]);
            int to = Integer.parseInt(inputEdge[1]);

            if (from == -1 && to == -1) {
                break;
            }

            nodes[from].edgeList.add(nodes[to]);
            nodes[to].edgeList.add(nodes[from]);
        }
        //** 입력 끝

        //각 노드의 친구 점수를 계산
        for (int i = 1; i < size + 1; i++) {
            initNodes(nodes);
            calculateFriendScore(nodes[i]);
        }

        Node[] presidents = filterPresident(nodes);

        System.out.printf("%d %d\n", presidents[0].score, presidents.length);
        Arrays.stream(presidents)
                .forEach(n -> System.out.print(n.number + " "));
    }
}

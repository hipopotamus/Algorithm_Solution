package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {

    static int[] moveSet = {1, -1, 2};

    private static class Node {

        int location;
        int time;

        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }

    private static int bfs(Node node, int k) {

        boolean[] check = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        check[node.location] = true;

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();
            int currentLocation = currentNode.location;
            int currentTime = currentNode.time;

            if (currentLocation == k) {
                return currentTime;
            }

            for (int i = 0; i < 3; i++) {

                int nextLocation;
                if (i == 2) {
                    nextLocation = currentLocation * moveSet[i];
                } else {
                    nextLocation = currentLocation + moveSet[i];
                }

                if (nextLocation < 0 || nextLocation > 100000 || check[nextLocation]) {
                    continue;
                }

                queue.offer(new Node(nextLocation, currentTime + 1));
                check[nextLocation] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Node node = new Node(n, 0);

        int result = bfs(node, k);

        System.out.println(result);
    }
}

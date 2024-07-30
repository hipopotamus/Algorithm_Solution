package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697_다른풀이 {
    static int[] moveSet = {1, -1, 2};

    private static class Node {

        int location;
        int time = 0;
        boolean check = false;

        public Node(int location) {
            this.location = location;
        }
    }

    private static int bfs(Node firstNode, int k, Node[] nodeArr) {

        Queue<Node> queue = new LinkedList<>();
        int result = 0;

        firstNode.check = true;
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.location == k) {
                result = node.time;
                return result;
            }

            for (int i = 0; i < 3; i++) {

                int nextLocation;
                if (i == 2) {
                    nextLocation = node.location * moveSet[i];
                } else {
                    nextLocation = node.location + moveSet[i];
                }

                if (nextLocation < 0 || nextLocation > 100000 || nodeArr[nextLocation].check) {
                    continue;
                }

                Node nextNode = nodeArr[nextLocation];
                nextNode.check = true;
                nextNode.time = node.time + 1;
                queue.offer(nextNode);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Node[] nodeArr = new Node[100001];

        for (int i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(i);
        }

        int result = bfs(nodeArr[n], k, nodeArr);

        System.out.println(result);
    }
}

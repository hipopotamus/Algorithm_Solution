package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알고스팟_1525 {

    static int[] moveSet = {-3, 1, 3, -1};

    private static class Node {

        int emptyLocation;
        int[] numberArr = new int[9];
        int count = 0;

        public Node(int beforeEmptyLocation, int emptyLocation, int[] numberArr, int count) {
            this.count = count;
            this.emptyLocation = emptyLocation;

            for (int i = 0; i < numberArr.length; i++) {
                this.numberArr[i] = numberArr[i];
            }

            int temp = this.numberArr[emptyLocation];
            this.numberArr[emptyLocation] = this.numberArr[beforeEmptyLocation];
            this.numberArr[beforeEmptyLocation] = temp;
        }

        public Node() {}
    }

    private static int intArrToInt(int[] numberArr) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i : numberArr) {
            stringBuilder.append(i);
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    private static Node bfs(Node firstNode, Map<Integer, Boolean> check, int dist) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(firstNode);

        int puzzleSet = intArrToInt(firstNode.numberArr);
        check.put(puzzleSet, true);

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();

            if (intArrToInt(currentNode.numberArr) == dist) {
                return currentNode;
            }

            for (int i = 0; i < 4; i++) {

                int nextEmptyLocation = currentNode.emptyLocation + moveSet[i];

                if (nextEmptyLocation < 0 || nextEmptyLocation > 8
                        || (currentNode.emptyLocation % 3 == 2 & i == 1) || (currentNode.emptyLocation % 3 == 0 & i == 3)) {
                    continue;
                }

                Node nextNode =
                        new Node(currentNode.emptyLocation, nextEmptyLocation, currentNode.numberArr, currentNode.count + 1);

                int nextPuzzleSet = intArrToInt(nextNode.numberArr);
                if (check.containsKey(nextPuzzleSet)) {
                    continue;
                }

                queue.offer(nextNode);
                check.put(nextPuzzleSet, true);
            }
        }

        return null;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node node = new Node();

        Map<Integer, Boolean> check = new HashMap<>();

        for (int i = 0; i < 3; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 0) {
                    node.emptyLocation = 3 * i + j;
                }

                node.numberArr[3 * i + j] = number;
            }
        }

        Node result = bfs(node, check, 123456780);

        if (result == null) {
            System.out.println(-1);
            return;
        }

        System.out.println(result.count);
    }
}

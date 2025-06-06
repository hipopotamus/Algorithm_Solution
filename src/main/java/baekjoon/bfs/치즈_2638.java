package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2638 {

    public static class Node {
        public int row;
        public int col;
        public int status;
        public boolean isVisited = false;
        public int contactStack = 0;

        public Node(int row, int col, int status) {
            this.row = row;
            this.col = col;
            this.status = status;
        }

        public void simulate() {
            if (contactStack >= 2) {
                status = 0;
            }
            isVisited = false;
            contactStack = 0;
        }

        public void visited() {
            isVisited = true;
        }

        public void contact() {
            contactStack++;
        }
    }

    public static void isOxidize(Node[][] map) {
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {-1, 0, 1, 0};
        Queue<Node> queue = new LinkedList<>();

        Node initNode = map[0][0];
        initNode.visited();
        queue.offer(initNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dRow[i];
                int nextCol = node.col + dCol[i];

                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length
                        || map[nextRow][nextCol].isVisited) {
                    continue;
                }

                Node nextNode = map[nextRow][nextCol];
                if (nextNode.status == 1) {
                    nextNode.contact();
                    continue;
                }

                nextNode.visited();
                queue.offer(nextNode);
            }
        }
    }

    public static boolean hasCheese(Node[][] map) {
        for (Node[] row : map) {
            for (Node node : row) {
                if (node.status == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int simulate(Node[][] map) {
        int time = 0;

        while (hasCheese(map)) {
            isOxidize(map);

            for (Node[] row : map) {
                for (Node node : row) {
                    node.simulate();
                }
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        Node[][] map = new Node[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                int status = Integer.parseInt(st.nextToken());
                map[i][j] = new Node(i, j, status);
            }
        }

        int totalTime = simulate(map);

        System.out.println(totalTime);
    }
}

package baekjoon.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양치기_꿍_3187 {

    static int sheep = 0;
    static int wolf = 0;

    public static class Node {
        char character;
        int row;
        int col;
        boolean isVisited = false;

        public Node(char character, int row, int col) {
            this.character = character;
            this.row = row;
            this.col = col;
        }
    }

    public static void searchSheepWolf(Node[][] map, Node firstNode) {

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int sheepCount = 0;
        int wolfCount = 0;

        Queue<Node> queue = new LinkedList<>();
        firstNode.isVisited = true;
        if (firstNode.character == 'k') {
            sheepCount++;
        } else if (firstNode.character == 'v') {
            wolfCount++;
        }
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + drow[i];
                int nextCol = node.col + dcol[i];

                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length ||
                map[nextRow][nextCol].isVisited || map[nextRow][nextCol].character == '#') {
                    continue;
                }

                Node nextNode = map[nextRow][nextCol];
                nextNode.isVisited = true;
                if (nextNode.character == 'k') {
                    sheepCount++;
                } else if (nextNode.character == 'v') {
                    wolfCount++;
                }
                queue.offer(nextNode);
            }
        }

        if (sheepCount > wolfCount) {
            sheep += sheepCount;
        } else if (wolfCount >= sheepCount) {
            wolf += wolfCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        Node[][] map = new Node[row][col];

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                char character = line.charAt(j);
                map[i][j] = new Node(character, i, j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Node node = map[i][j];
                if (node.isVisited || node.character == '#') {
                    continue;
                }
                searchSheepWolf(map, node);
            }
        }

        sb.append(sheep).append(" ").append(wolf);
        bw.write(sb.toString());
        bw.flush();
    }
}

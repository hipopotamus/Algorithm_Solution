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

    //한 울타리 안에 살아남는 양 또는 늑대를 구하는 메서드
    //BFS로 배열을 탐색한다.
    public static void searchSheepWolf(Node[][] map, Node firstNode) {

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int sheepCount = 0;
        int wolfCount = 0;

        Queue<Node> queue = new LinkedList<>();

        firstNode.isVisited = true;
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.character == 'k') {
                sheepCount++;
            } else if (node.character == 'v') {
                wolfCount++;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + drow[i];
                int nextCol = node.col + dcol[i];

                //탐색 불가능 조건
                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length ||
                map[nextRow][nextCol].isVisited || map[nextRow][nextCol].character == '#') {
                    continue;
                }

                Node nextNode = map[nextRow][nextCol];

                //노드를 탐색할 때, 해당 노드가 양 또는 늑대인지를 파악해서 카운트에 반영한다.
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

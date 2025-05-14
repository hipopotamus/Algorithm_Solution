package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소_14502 {

    public static class Node {
        int row;
        int col;
        int rawStatus;
        int status;

        public Node(int row, int col, int rawStatus) {
            this.row = row;
            this.col = col;
            this.rawStatus = rawStatus;
        }

        public void init() {
            this.status = rawStatus;
        }
    }

    public static int simulateVirusSpread(Node[][] map, List<Node> virusList, int spreadableZone) {
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};
        int virusZone = 0;

        Queue<Node> queue = new LinkedList<>();
        for (Node node : virusList) {
            queue.offer(node);
            virusZone++;
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dRow[i];
                int nextCol = node.col + dCol[i];

                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length
                        || map[nextRow][nextCol].status != 0) {
                    continue;
                }

                Node nextNode = map[nextRow][nextCol];
                nextNode.status = 2;
                virusZone++;

                queue.offer(nextNode);
            }
        }

        return spreadableZone - virusZone;
    }

    public static int getMaxSafeZone(Node[][] map, List<Node> nodeList, List<Node> virusList, int spreadableZone) {
        int maxSafeZone = 0;

        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = i + 1; j < nodeList.size(); j++ ) {
                for (int k = j + 1; k < nodeList.size(); k++) {
                    nodeList.forEach(Node::init);

                    if (nodeList.get(i).status != 0 || nodeList.get(j).status != 0 || nodeList.get(k).status != 0) {
                        continue;
                    }

                    nodeList.get(i).status = 1;
                    nodeList.get(j).status = 1;
                    nodeList.get(k).status = 1;

                    int safeZone = simulateVirusSpread(map, virusList, spreadableZone - 3);

                    if (safeZone > maxSafeZone) {
                        maxSafeZone = safeZone;
                    }
                }
            }
        }

        return maxSafeZone;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        Node[][] map = new Node[rowSize][colSize];
        List<Node> nodeList = new ArrayList<>();
        List<Node> virusList = new ArrayList<>();
        int spreadableZone;
        int wallCount = 0;

        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < colSize; j++) {
                int status = Integer.parseInt(st.nextToken());
                Node node = new Node(i, j, status);

                map[i][j] = node;
                nodeList.add(node);

                if (status == 1) {
                    wallCount++;
                }

                if (status == 2) {
                    virusList.add(node);
                }
            }
        }

        spreadableZone = nodeList.size() - wallCount;

        int maxSafeZone = getMaxSafeZone(map, nodeList, virusList, spreadableZone);

        System.out.println(maxSafeZone);
    }
}

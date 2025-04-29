package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알파벳_1987_실패 {

    public static class Node {
        char alphabet;
        int row;
        int col;
        int dist = 1;
        int visited = 0;

        public int isVisitedPath(char alphabet) {
            return visited & 1 << (alphabet - 'A');
        }

        public Node(char alphabet, Node beforeNode, int row, int col) {
            this.alphabet = alphabet;
            this.visited = beforeNode.visited;
            this.visited |= 1 << (alphabet - 'A');
            this.row = row;
            this.col = col;
        }

        public Node(char alphabet, int row, int col) {
            this.alphabet = alphabet;
            this.visited |= 1 << (alphabet - 'A');
            this.row = row;
            this.col = col;
        }
    }

    public static int getMaxDist(char[][] nodeArray, Node firstNode) {
        int maxDist = 1;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            maxDist = node.dist;

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dRow[i];
                int nextCol = node.col + dCol[i];

                if (nextRow < 0 || nextRow >= nodeArray.length || nextCol < 0 || nextCol >= nodeArray[0].length ||
                        node.isVisitedPath(nodeArray[nextRow][nextCol]) != 0) {
                    continue;
                }

                Node nextNode = new Node(nodeArray[nextRow][nextCol], node, nextRow, nextCol);
                nextNode.dist = node.dist + 1;
                queue.offer(nextNode);
            }
        }

        return maxDist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] alphabetArray = new char[row][col];

        for (int i = 0; i < row; i++) {
            String info = br.readLine();
            for (int j = 0; j < col; j++) {
                alphabetArray[i][j] = info.charAt(j);
            }
        }

        int maxDist = getMaxDist(alphabetArray, new Node(alphabetArray[0][0], 0, 0));

        System.out.println(maxDist);
    }
}

package showmethecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 문제2 {

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    private static class Node {

        int row;
        int col;
        int state;
        boolean check = false;

        public Node(int row, int col, int state) {
            this.row = row;
            this.col = col;
            this.state = state;
        }
    }

    private static void bfs(Node firstNode, Node[][] nodeArr) {

        int rowSize = nodeArr.length;
        int colSize = nodeArr[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(firstNode);
        firstNode.check = true;

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = (currentNode.row + dRow[i]) % rowSize;
                int nextCol = (currentNode.col + dCol[i]) % colSize;

                if (nextRow == -1) {
                    nextRow = rowSize - 1;
                }
                if (nextCol == -1) {
                    nextCol = colSize - 1;
                }

                if (nodeArr[nextRow][nextCol].state == 1 || nodeArr[nextRow][nextCol].check) {
                    continue;
                }

                Node nextNode = nodeArr[nextRow][nextCol];
                queue.offer(nextNode);
                nextNode.check = true;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int result = 0;

        Node[][] nodeArr = new Node[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                int state = Integer.parseInt(st.nextToken());
                nodeArr[i][j] = new Node(i, j, state);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (nodeArr[i][j].state == 1 || nodeArr[i][j].check) {
                    continue;
                }
                bfs(nodeArr[i][j], nodeArr);
                result++;
            }
        }

        System.out.println(result);
    }
}

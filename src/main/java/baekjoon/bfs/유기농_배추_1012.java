package baekjoon.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농_배추_1012 {

    static int warmCount = 0;

    public static class Node {
        int row;
        int col;
        boolean isCabbage = false;
        boolean check = false;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    private static void checkCabbageByBfs(Node[][] nodeArr, int row, int col) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Node firstNode = nodeArr[row][col];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(firstNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dx[i];
                int nextCol = node.col + dy[i];

                if (nextRow < 0 || nextRow >= nodeArr.length || nextCol < 0 || nextCol >= nodeArr[0].length ||
                !nodeArr[nextRow][nextCol].isCabbage || nodeArr[nextRow][nextCol].check) {
                    continue;
                }

                Node nextNode = nodeArr[nextRow][nextCol];
                nextNode.check = true;
                queue.offer(nextNode);
            }
        }

        warmCount++;
    }

    private static Node[][] initNodeArr(int row, int col, int cabbageNumber, BufferedReader br) throws IOException {
        Node[][] nodeArr = new Node[row][col];
        for (int n = 0; n < row; n++) {
            for (int m = 0; m < col; m++) {
                nodeArr[n][m] = new Node(n, m);
            }
        }

        for (int i = 0; i < cabbageNumber; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int cabbageRow = Integer.parseInt(st2.nextToken());
            int cabbageCol = Integer.parseInt(st2.nextToken());
            nodeArr[cabbageRow][cabbageCol].isCabbage = true;
        }
        return nodeArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            warmCount = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int cabbageNumber = Integer.parseInt(st.nextToken());

            Node[][] nodeArr = initNodeArr(row, col, cabbageNumber, br);

            for (int n = 0; n < row; n++) {
                for (int m = 0; m < col; m++) {
                    if (nodeArr[n][m].check || !nodeArr[n][m].isCabbage) {
                        continue;
                    }
                    checkCabbageByBfs(nodeArr, n, m);
                }
            }

            bw.write(String.format("%d\n", warmCount));
        }
        bw.flush();
    }
}

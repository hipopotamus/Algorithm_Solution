package baekjoon.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리_14940 {

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCow = {0, 1, 0, -1};

    public static class Node {
        int row;
        int col;
        int distance = -1;
        boolean check = false;
        boolean isBlock = false;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static Node initNodeArr(BufferedReader br, Node[][] nodeArr) throws IOException {
        Node initialNode = null;
        StringTokenizer st;

        for (int row = 0; row < nodeArr.length; row++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int col = 0; col < nodeArr[0].length; col++) {
                int number = Integer.parseInt(st.nextToken());
                Node node = new Node(row, col);

                if (number == 2) {
                    node.distance = 0;
                    initialNode = node;
                } else if (number == 0) {
                    node.distance = 0;
                    node.isBlock = true;
                }

                nodeArr[row][col] = node;
            }
        }

        return initialNode;
    }

    private static void getDistanceByBfs(Node[][] nodeArr, Node initialNode) {
        Queue<Node> queue = new LinkedList<>();
        initialNode.check = true;
        queue.offer(initialNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dRow[i];
                int nextCol = node.col + dCow[i];
                if (nextRow < 0 || nextRow >= nodeArr.length || nextCol < 0 || nextCol >= nodeArr[0].length
                        || nodeArr[nextRow][nextCol].check || nodeArr[nextRow][nextCol].isBlock) {
                    continue;
                }
                Node nextNode = nodeArr[nextRow][nextCol];
                nextNode.check = true;
                nextNode.distance = node.distance + 1;

                queue.offer(nextNode);
            }
        }
    }

    private static void outPutDistance(BufferedWriter bw, Node[][] nodeArr) throws IOException {
        for (int row = 0; row < nodeArr.length; row++) {
            for (int col = 0; col < nodeArr[0].length; col++) {
                int distance = nodeArr[row][col].distance;
                bw.write(String.valueOf(distance));
                if (col != nodeArr[0].length - 1) {
                    bw.write(" ");
                }
            }
            bw.newLine();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        Node[][] nodeArr = new Node[rowSize][colSize];

        Node initialNode = initNodeArr(br, nodeArr);
        getDistanceByBfs(nodeArr, initialNode);

        outPutDistance(bw, nodeArr);
        bw.flush();
    }
}

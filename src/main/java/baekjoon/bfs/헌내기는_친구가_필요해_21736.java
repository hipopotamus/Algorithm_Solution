package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는_친구가_필요해_21736 {

    public static class Node {
        int row;
        int col;
        char status;
        boolean isCheck = false;

        public Node(int row, int col, char status) {
            this.row = row;
            this.col = col;
            this.status = status;
        }
    }

    public static int countMeetablePeople(Node[][] campus, Node startNode) {
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + dRow[i];
                int nextCol = node.col + dCol[i];

                if (nextRow < 0 || nextRow >= campus.length || nextCol < 0 || nextCol >= campus[0].length ||
                campus[nextRow][nextCol].isCheck || campus[nextRow][nextCol].status == 'X') {
                    continue;
                }

                if (campus[nextRow][nextCol].status == 'P') {
                    count++;
                }

                campus[nextRow][nextCol].isCheck = true;

                queue.offer(campus[nextRow][nextCol]);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        Node[][] campus = new Node[row][col];
        Node startNode = new Node(0, 0, 'I');

        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                char status = line.charAt(j);
                campus[i][j] = new Node(i, j, status);

                if (status == 'I') {
                    startNode = campus[i][j];
                }
            }
        }

        int countedPeople = countMeetablePeople(campus, startNode);

        if (countedPeople == 0) {
            System.out.println("TT");
        } else {
            System.out.println(countedPeople);
        }
    }
}

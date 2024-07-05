package baekjoon.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과_사다리_게임_16928 {
    public static class Node {
        int number;
        Integer to;
        int distinct = 0;
        boolean visited = false;

        public Node(int number) {
            this.number = number;
        }
    }

    public static int minPathByBfs(Node[] board) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(board[1]);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int nextNumber = node.number + i;
                if (nextNumber > 100 || board[nextNumber].visited) {
                    continue;
                }

                if (board[nextNumber].to != null) {
                    board[nextNumber].distinct =  node.distinct + 1; //사다리/뱀 노드에 도착했을때 위치가 변하기 때문에 두번 체크해야함
                    board[nextNumber].visited = true;

                    nextNumber = board[nextNumber].to;
                    if (board[nextNumber].visited) {
                        continue;
                    }
                }

                Node nextNode = board[nextNumber];
                nextNode.distinct = node.distinct + 1; //사다리/뱀 노드에 도착했을때 위치가 변하기 때문에 두번 체크해야함
                nextNode.visited = true;
                queue.offer(nextNode);

                if (nextNumber == 100) {
                    return nextNode.distinct;
                }
            }
        }

        return 0;
    }

    public static void initBoard(Node[] board) {
        for (int i = 1; i < board.length; i++) {
            board[i] = new Node(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node[] board = new Node[101];

        initBoard(board);
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        for (int i = 0; i < ladder + snake; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from].to = to;
        }

        int minPath = minPathByBfs(board);

        bw.write(String.valueOf(minPath));
        bw.flush();
    }
}

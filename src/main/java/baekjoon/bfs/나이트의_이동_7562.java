package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의_이동_7562 {

    //나이트의 정보를 담고있는 클래스
    //dist = 주어진 초기 나이트로부터의 거리
    public static class Knight {
        int row;
        int col;
        int dist = 0;
        boolean check = false;

        public Knight(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    //초기 나이트로부터 이동할 수 있는 나이트의 위치를 탐색하며 거리를 계산한다.
    //목표 좌표와 초기 나이트의 위치가 같으면 초기 나이트의 거리(=0)을 반환
    public static int bfs(Knight[][] knightArray, Knight startKnight, int destRow, int destCol) {
        if (startKnight.row == destRow && startKnight.col == destCol) {
            return startKnight.dist;
        }

        int[] rowSet = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colSet = {1, 2, 2, 1, -1, -2, -2, -1};
        Queue<Knight> queue = new LinkedList<>();
        startKnight.check = true;
        queue.offer(startKnight);

        while (!queue.isEmpty()) {
            Knight knight = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextRow = knight.row + rowSet[i];
                int nextCol = knight.col + colSet[i];
                if (nextRow < 0 || nextRow >= knightArray.length || nextCol < 0 || nextCol >= knightArray.length
                        || knightArray[nextRow][nextCol].check) {
                    continue;
                }

                Knight nextKnight = knightArray[nextRow][nextCol];
                nextKnight.dist = knight.dist + 1;
                nextKnight.check = true;

                if (nextKnight.row == destRow && nextKnight.col == destCol) {
                    return nextKnight.dist;
                }
                queue.offer(nextKnight);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();

        while (total-- > 0) {
            //초기화 시작
            int size = scanner.nextInt();

            Knight[][] knightArray = new Knight[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    knightArray[i][j] = new Knight(i, j);
                }
            }
            Knight startKnight = knightArray[scanner.nextInt()][scanner.nextInt()];
            int destRow = scanner.nextInt();
            int destCol = scanner.nextInt();
            //초기화 끝

            int result = bfs(knightArray, startKnight, destRow, destCol);
            System.out.println(result);
        }
    }
}

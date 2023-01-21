package baekjoon.bfs;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보물섬_2589 {

    public static class Info {   //배열의 원소 정보를 담은 클래스
        Point point;
        boolean land;
        boolean check = false;
        int dist = 0;

        public Info(Point point, boolean land) {
            this.point = point;
            this.land = land;
        }
    }

    public static void initMap(Info[][] map) {   //map의 check와 dist를 초기화 해주는 메서드
        for (Info[] infos : map) {
            for (Info info : infos) {
                if (!info.land || !info.check) {
                    continue;
                }
                info.check = false;
                info.dist = 0;
            }
        }
    }

    public static int bfs(Info[][] map, int row, int col) {   //bfs를 사용해 주어진 시작점부터 최대 거리를 구하는 메서드
        int[] rowSet = {-1, 0, 1, 0};
        int[] colSet = {0, 1, 0, -1};
        int maxDist = 0;

        Info initInfo = map[row][col];
        Queue<Info> queue = new LinkedList<>();

        initInfo.check = true;
        queue.offer(initInfo);

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            for (int i = 0; i < 4; i++) {   //상하좌우 방향으로 탐색을 시도
                int nextRow = info.point.x + rowSet[i];
                int nextCol = info.point.y + colSet[i];
                if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map[0].length   //조건에 따라 탐색하지 않는 방향 넘기기
                        || !map[nextRow][nextCol].land || map[nextRow][nextCol].check) {
                    continue;
                }

                Info nextInfo = map[nextRow][nextCol];
                nextInfo.check = true;
                nextInfo.dist = info.dist + 1;
                queue.offer(nextInfo);
            }

            if (queue.isEmpty()) {   //마지막 탐색 = 시작점으로 부터 최대거리에 떨어져있는 원소의 거리를 저장
                maxDist = info.dist;
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        Info[][] map = new Info[row][col];

        int answer = 0;

        for (int i = 0; i < row; i++) {
            String rowString = scanner.next();
            for (int j = 0; j < col; j++) {
                boolean land = rowString.charAt(j) == 'L';
                map[i][j] = new Info(new Point(i, j), land);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!map[i][j].land) {
                    continue;
                }
                initMap(map);
                int maxDist = bfs(map, i, j);
                if (answer < maxDist) {
                    answer = maxDist;
                }
            }
        }

        System.out.println(answer);
    }
}

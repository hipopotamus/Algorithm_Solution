package baekjoon.bfs;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 토마토_7569 {

    public static class Tomato {
        int row;
        int col;
        int height;
        int status;
        int day = 0;

        public Tomato(int row, int col, int height, int status) {
            this.row = row;
            this.col = col;
            this.height = height;
            this.status = status;
        }
    }

    private static Tomato[][][] initTomatoBoxes() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());
        int heightSize = Integer.parseInt(st.nextToken());

        Tomato[][][] tomatoBoxes = new Tomato[heightSize][rowSize][colSize];

        for (int h = 0; h < heightSize; h++) {
            for (int i = 0; i < rowSize; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < colSize; j++) {
                    int status = Integer.parseInt(st.nextToken());
                    tomatoBoxes[h][i][j] = new Tomato(i, j, h, status);
                }
            }
        }

        return tomatoBoxes;
    }

    private static List<Tomato> findRipenedTomato(Tomato[][][] tomatoBoxes) {
        return Arrays.stream(tomatoBoxes)
                .flatMap(Arrays::stream)
                .flatMap(Arrays::stream)
                .filter(tomato -> tomato.status == 1)
                .collect(Collectors.toList());
    }

    private static boolean checkNotRipen(Tomato[][][] tomatoBoxes) {
        return Arrays.stream(tomatoBoxes)
                .flatMap(Arrays::stream)
                .flatMap(Arrays::stream)
                .mapToInt(tomato -> tomato.status)
                .anyMatch(status -> status == 0);
    }

    private static int calculateDaysByBfs(Tomato[][][] tomatoBoxes) {
        int[] rowSet = {-1, 0, 1, 0, 0, 0};
        int[] colSet = {0, 1, 0, -1, 0, 0};
        int[] heightSet = {0, 0, 0, 0, -1, 1};
        int days = 0;

        Queue<Tomato> queue = new LinkedList<>();
        List<Tomato> ripenedTomatoes = findRipenedTomato(tomatoBoxes);
        for (Tomato tomato : ripenedTomatoes) {
            queue.offer(tomato);
        }

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nextRow = tomato.row + rowSet[i];
                int nextCol = tomato.col + colSet[i];
                int nextHeight = tomato.height + heightSet[i];
                if (nextRow < 0 || nextRow >= tomatoBoxes[0].length ||
                        nextCol < 0 || nextCol >= tomatoBoxes[0][0].length ||
                        nextHeight < 0 || nextHeight >= tomatoBoxes.length ||
                        tomatoBoxes[nextHeight][nextRow][nextCol].status == -1 ||
                        tomatoBoxes[nextHeight][nextRow][nextCol].status == 1) {
                    continue;
                }

                Tomato nextTomato = tomatoBoxes[nextHeight][nextRow][nextCol];
                nextTomato.day = tomato.day + 1;
                nextTomato.status = 1;
                queue.offer(nextTomato);
                }

            if (queue.isEmpty()) {
                days = tomato.day;
            }
        }

        return days;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Tomato[][][] tomatoBoxes = initTomatoBoxes();
        int days = calculateDaysByBfs(tomatoBoxes);
        int result;

        if (checkNotRipen(tomatoBoxes)) {
            result = -1;
        } else {
            result = days;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

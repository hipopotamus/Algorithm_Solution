package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 별찍기_11_2448 {

    public static void drawStar(char[][] map, int row, int col, int size) {
        if (size == 3) {
            map[row][col] = '*';
            map[row + 1][col - 1] = '*';
            map[row + 1][col + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                map[row + 2][col + i] = '*';
            }
            return;
        }

        int half = size / 2;

        drawStar(map, row, col , half);
        drawStar(map, row + half, col - half, half);
        drawStar(map, row + half, col + half, half);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        char[][] map = new char[size][2 * size - 1];
        for (char[] row : map) {
            Arrays.fill(row, ' ');
        }

        drawStar(map, 0, size - 1, size);

        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            sb.append(row).append('\n');
        }

        System.out.print(sb);
    }
}

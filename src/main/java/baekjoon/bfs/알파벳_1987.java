package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {

    public static int maxDist = 0;
    public static int[] dRow = {-1, 0, 1, 0};
    public static int[] dCol = {0, 1, 0, -1};

    public static void searchPath(char[][] alphabetArray, int depth, int row, int col, int visited) {
        if (depth > maxDist) {
            maxDist = depth;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if (nextRow < 0 || nextRow >= alphabetArray.length || nextCol < 0 || nextCol >= alphabetArray[0].length ||
                    ((visited & 1 << (alphabetArray[nextRow][nextCol] - 'A')) != 0)) {
                continue;
            }

            int nextVisited = visited | (1 << (alphabetArray[nextRow][nextCol] - 'A'));
            searchPath(alphabetArray, depth + 1, nextRow, nextCol, nextVisited);
        }
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

        searchPath(alphabetArray, 1, 0, 0, 1 << (alphabetArray[0][0] - 'A'));

        System.out.println(maxDist);
    }
}

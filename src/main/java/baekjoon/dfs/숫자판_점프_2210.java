package baekjoon.dfs;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자판_점프_2210 {

    static int[] drow = {-1, 0, 1, 0};
    static int[] dcol = {0, 1, 0, -1};

    //주어진 지점부터 배열을 5번 탐색하는 메서드
    //배열을 탐색하면서 조합된 숫자를 Set에 넣는다.
    public static void dfs(Set<String> caseSet, String number, int[][] board, int depth, int maxDepth,
                           int row, int col) {
        if (depth == maxDepth) {
            caseSet.add(number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];

            //탐색 불가능 조건
            if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length) {
                continue;
            }

            //현재 깊이 까지 조합된 숫자
            String savedNumber = number + board[nextRow][nextCol];

            dfs(caseSet, savedNumber, board, depth + 1, maxDepth, nextRow, nextCol);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> caseSet = new HashSet<>();
        int[][] board = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                board[i][j] = number;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(caseSet, String.valueOf(board[i][j]), board, 0, 5, i, j);
            }
        }

        bw.write(String.valueOf(caseSet.size()));
        bw.flush();
    }
}

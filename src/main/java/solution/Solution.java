package solution;

/*
LeetCode 130번 문제
https://leetcode.com/problems/surrounded-regions/
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static boolean isFlip;   //뒤집을 수 있는 'O'의 집합인지를 판단하는 플래그

    public static class Index{   //board에서 뒤집을 인덱스를 저장
        int row;
        int col;

        public Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void dfs(char[][] board, boolean[][] check, int row, int col, List<Index> indexList) {
        int[] rowSet = {-1, 0, 1, 0};
        int[] colSet = {0, 1, 0, -1};

        check[row][col] = true;
        indexList.add(new Index(row, col));

        for (int i = 0; i < 4; i++) {
            int nextRow = row + rowSet[i];
            int nextCol = col + colSet[i];
            if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length) {
                isFlip = false;   //경계에 접하면 Filp할 수없는 집합이기 때문에 플래그를 false로 변경
                continue;
            }
            if (check[nextRow][nextCol] || board[nextRow][nextCol] == 'X') {
                continue;
            }
            dfs(board, check, nextRow, nextCol, indexList);
        }
    }

    private void flip(char[][] board, List<Index> indexList) {   //주어진 idnexList의 원소들로 board의 'O'집합을 Filp하는 메서드
        for (Index index : indexList) {
            board[index.row][index.col] = 'X';
        }
    }

    public void solve(char[][] board) {

        boolean[][] check = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check[i][j] || board[i][j] == 'X') {
                    continue;
                }

                isFlip = true;
                List<Index> indexList = new ArrayList<>();
                dfs(board, check, i, j, indexList);

                if (isFlip) {
                    flip(board, indexList);
                }
            }
        }
    }
}

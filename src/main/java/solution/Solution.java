package solution;

//프로그래머스 데브매칭 2번재 문제

public class Solution {
    int count = 2;
    int[] rowSet = {-1, 0, 1, 0};
    int[] colSet = {0, 1, 0, -1};

    public void make_answer(int[][] answer, int n, int row, int col, int rowMax, int colMax) {

        while (answer[0][n - 1] == 0 || answer[n - 1][0] == 0) {   //반복문 돌때마다 한칸씩 이동하며 숫자 기록
            boolean last = true;
            answer[row][col] = count;
            count++;

            for (int i = 0; i < 4; i++) {   //조건에 의해 테두리를 이동
                int nextRow = row + rowSet[i];
                int nextCol = col + colSet[i];
                if (nextRow >= n || nextRow < 0 || nextRow > rowMax || nextCol >= n || nextCol < 0 || nextCol > colMax
                        || answer[nextRow][nextCol] != 0) {
                    continue;
                }
                row = nextRow;
                col = nextCol;
                last = false;
                break;
            }

            if (last) {   //테두리를 다 탐색했다면 다음 칸으로 이동
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + rowSet[i];
                    int nextCol = col + colSet[i];
                    if (nextRow >= n || nextRow < 0 || nextCol >= n || nextCol < 0 || answer[nextRow][nextCol] != 0) {
                        continue;
                    }
                    row = nextRow;
                    col = nextCol;
                    rowMax = Math.max(nextRow, nextCol);
                    colMax = Math.max(nextRow, nextCol);
                    break;
                }
            }
        }
    }

    public int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];
        answer[0][0] = 1;

        if (horizontal) {   //horizontal에 따라 (0,0)부터 수직, 수평으로 한칸 이동
            make_answer(answer, n, 0, 1, 1, 1);
        } else {
            make_answer(answer, n, 1, 0, 1, 1);
        }
        return answer;
    }
}

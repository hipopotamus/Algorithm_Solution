package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 효구와_호규_Easy_26085 {

    public static int judgeDeleteCard(int[][] board) {
        int oneCount = 0;
        int zeroCount = 0;
        int flag = 0;
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {-1, 0, 1, 0};

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int cardNumber = board[row][col];

                if (cardNumber == 1) {
                    oneCount++;
                } else if (cardNumber == 0) {
                    zeroCount++;
                }

                for (int k = 0; k < 4; k++) {
                    int nextRow = row + drow[k];
                    int nextCol = col + dcol[k];
                    if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length ||
                            board[nextRow][nextCol] != cardNumber) {
                        continue;
                    }
                    flag = 1;
                }
            }
        }

        if (oneCount % 2 != 0 || zeroCount % 2 != 0) {
            return -1;
        } else if (flag == 0) {
            return -1;
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] board = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = judgeDeleteCard(board);

        System.out.println(result);
    }
}

package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class 마인크래프트_18111 {

    static int minTime = Integer.MAX_VALUE;
    static int highestBlock = 0;

    //targetHeight 보다 블럭이 높으면 깎고 낮으면 인벤토리에있는 블럭을 쌓는 메서드
    public static boolean smoothGround(int[][] blockMap, int inventory, int targetHeight) {
        int time = 0;

        for (int i = 0; i < blockMap.length; i++) {
            for (int j = 0; j < blockMap[i].length; j++) {
                int block = blockMap[i][j];
                if (block > targetHeight) {
                    inventory += block - targetHeight;
                    time += 2 * (block - targetHeight);
                } else if (block < targetHeight) {
                    inventory -= targetHeight - block;
                    time += (targetHeight - block);
                }
            }
        }

        //targetHeight에 맞춰 모든 작업을 마치고 inventory가 음수가 아니라면 평탄화 작업이 문제없이 이루어진것
        //음수라면 평탄화작업이 불가능한 상황을 뜻함
        if (inventory >= 0) {
            if (minTime >= time) {
                minTime = time;
                highestBlock = targetHeight;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int maxHeight = 0;
        int minHeight = Integer.MAX_VALUE;

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int inventory = Integer.parseInt(st.nextToken());

        int[][] blockMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                blockMap[i][j] = Integer.parseInt(st.nextToken());

                if (blockMap[i][j] > maxHeight) {
                    maxHeight = blockMap[i][j];
                }
                if (blockMap[i][j] < minHeight) {
                    minHeight = blockMap[i][j];
                }
            }
        }

        //최소 높이와 최대 높이의 사이에서 평탄화가 가능한 최대 높이를 찾는다
        for (int i = minHeight; i <= maxHeight; i++) {
            boolean flag = smoothGround(blockMap, inventory, i);
            if (!flag) {
                break;
            }
        }

        bw.write(sb.append(minTime).append(" ").append(highestBlock).toString());
        bw.flush();
    }
}

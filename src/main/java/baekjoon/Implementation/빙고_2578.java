package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빙고_2578 {

    public static class Node {
        boolean check = false;
    }

    public static int checkBingo(Node[][] bingoMap) {
        int count = 0;

        for (int row = 0; row < 5; row++) {
            if (bingoMap[row][0].check && bingoMap[row][1].check && bingoMap[row][2].check && bingoMap[row][3].check
                    && bingoMap[row][4].check) {
                count++;
            }
        }

        for (int col = 0; col < 5; col++) {
            if (bingoMap[0][col].check && bingoMap[1][col].check && bingoMap[2][col].check && bingoMap[3][col].check
                    && bingoMap[4][col].check) {
                count++;
            }
        }

        if (bingoMap[0][0].check && bingoMap[1][1].check & bingoMap[2][2].check & bingoMap[3][3].check
                && bingoMap[4][4].check) {
            count++;
        }

        if (bingoMap[0][4].check && bingoMap[1][3].check & bingoMap[2][2].check & bingoMap[3][1].check
                && bingoMap[4][0].check) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node[] numberSet = new Node[26];
        Node[][] bingoMap = new Node[5][5];

        for (int i = 0; i < 5; i++) {
            String[] inputNumber = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(inputNumber[j]);
                numberSet[number] = new Node();
                bingoMap[i][j] = numberSet[number];
            }
        }

        int count = 0;
        boolean check = false;
        for (int i = 0; i < 5; i++) {
            String[] inputNumber = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                count++;
                int number = Integer.parseInt(inputNumber[j]);
                numberSet[number].check = true;

                int bingoNumber = checkBingo(bingoMap);
                if (bingoNumber >= 3 && !check) {
                    System.out.println(count);
                    check = true;
                    break;
                }
            }
        }
    }
}

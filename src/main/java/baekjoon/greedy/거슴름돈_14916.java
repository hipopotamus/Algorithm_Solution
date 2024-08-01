package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거슴름돈_14916 {

    public static int calculateMinCoins(int change) {

        for (int fiveCoins = (change / 5); fiveCoins >= 0; fiveCoins--) {
            int sum = 0;
            sum += fiveCoins;
            int changeByFive = change - (5 * fiveCoins);

            if (changeByFive % 2 == 0) {
                sum += changeByFive / 2;
                return sum;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int change = Integer.parseInt(br.readLine());

        int minCoins = calculateMinCoins(change);

        System.out.println(minCoins);
    }
}

package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 서강그라운드_14938 {

    public static void calculateMinPayoff(int[][] payoff) {
        for (int k = 1; k < payoff.length; k++) {
            for (int i = 1; i < payoff.length; i++) {
                for (int j = 1; j < payoff.length; j++) {
                    if (payoff[i][j] > payoff[i][k] + payoff[k][j]
                            && (payoff[i][k] != Integer.MAX_VALUE && payoff[k][j] != Integer.MAX_VALUE)) {
                        payoff[i][j] = payoff[i][k] + payoff[k][j];
                    }
                }
            }
        }
    }

    public static int getMaxItem(int[][] payoff, int[] items, int range) {
        int maxItem = 0;

        for (int i = 1; i < payoff.length; i++) {
            int itemCount = items[i];
            for (int j = 1; j < payoff.length; j++) {
                if (payoff[i][j] <= range && i != j) {
                    itemCount += items[j];
                }
            }

            if (itemCount > maxItem) {
                maxItem = itemCount;
            }
        }

        return maxItem;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputInfo = br.readLine().split(" ");
        int size = Integer.parseInt(inputInfo[0]);
        int range = Integer.parseInt(inputInfo[1]);
        int edgeSize = Integer.parseInt(inputInfo[2]);

        int[] items = new int[size + 1];
        int[][] payoff = new int[size + 1][size + 1];

        for (int i = 1; i < payoff.length; i++) {
            for (int j = 1; j < payoff.length; j++) {
                payoff[i][j] = Integer.MAX_VALUE;
            }
        }

        String[] inputItem = br.readLine().split(" ");
        for (int i = 0; i < inputItem.length; i++) {
            items[i + 1] = Integer.parseInt(inputItem[i]);
        }

        for (int i = 0; i < edgeSize; i++) {
            String[] inputEdge = br.readLine().split(" ");
            int from = Integer.parseInt(inputEdge[0]);
            int to = Integer.parseInt(inputEdge[1]);
            int pay = Integer.parseInt(inputEdge[2]);

            payoff[to][from] = pay;
            payoff[from][to] = pay;
        }

        calculateMinPayoff(payoff);
        int maxItem = getMaxItem(payoff, items, range);

        System.out.println(maxItem);
    }
}

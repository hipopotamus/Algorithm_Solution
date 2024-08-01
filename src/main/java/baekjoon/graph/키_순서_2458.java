package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 키_순서_2458 {

    public static void findPaths(boolean[][] path) {
        for (int k = 0; k < path.length; k++) {
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path.length; j++) {
                    if (path[i][k] && path[k][j]) {
                        path[i][j] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        String[] inputSize = br.readLine().split(" ");
        int size = Integer.parseInt(inputSize[0]);
        int edgeSize = Integer.parseInt(inputSize[1]);

        boolean[][] path = new boolean[size][size];
        int[] count = new int[size];

        for (int i = 0; i < edgeSize; i++) {
            String[] inputEdge = br.readLine().split(" ");
            int from = Integer.parseInt(inputEdge[0]);
            int to = Integer.parseInt(inputEdge[1]);

            path[from - 1][to - 1] = true;
        }

        findPaths(path);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (path[i][j] || path[j][i]) {
                    count[i]++;
                }
            }
        }

        for (int cnt : count) {
            if (cnt == size - 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}

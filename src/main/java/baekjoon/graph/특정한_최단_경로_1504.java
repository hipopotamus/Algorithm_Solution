package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 특정한_최단_경로_1504 {
    public static void floydWarshell(int[][] dist) {
        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static int findMinPathThroughTwoPoints(int[][] dist, int start, int end, int point1, int point2) {
        if (point1 == start && point2 == end) {
            return dist[start][end];
        } else if (point1 == start) {
            return dist[start][point2] + dist[point2][end];
        } else if (point2 == end) {
            return dist[start][point1] + dist[point1][end];
        }

        int path1 = dist[start][point1] + dist[point1][point2] + dist[point2][end];
        int path2 = dist[start][point2] + dist[point2][point1] + dist[point1][end];
        int minPath = Math.min(path1, path2);

        return minPath;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        int bigInt = 10000000;

        int[][] dist = new int[nodeSize][nodeSize];
        for (int[] row : dist) {
            Arrays.fill(row, bigInt);
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());

            dist[from][to] = distance;
            dist[to][from] = distance;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int point1 = Integer.parseInt(st.nextToken()) - 1;
        int point2 = Integer.parseInt(st.nextToken()) - 1;

        floydWarshell(dist);

        int minDistance = findMinPathThroughTwoPoints(dist, 0, nodeSize - 1, point1, point2);

        if (minDistance >= bigInt) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }
    }
}

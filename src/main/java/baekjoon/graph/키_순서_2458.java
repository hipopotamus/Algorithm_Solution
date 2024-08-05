package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 키_순서_2458 {

    //플로이드-워셜 알고리즘을 사용해서 각 학생간 경로가 존재하는지 확인한다.
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

    //키 순서를 알 수 있는 조건 = 정방향과 역방향으로 모든 노드들과 연결되어있어야 한다.
    private static int getResult(int size, boolean[][] path) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (path[i][j] || path[j][i]) {
                    count++;
                }
            }
            if (count == size - 1) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = br.readLine().split(" ");
        int size = Integer.parseInt(inputSize[0]);
        int edgeSize = Integer.parseInt(inputSize[1]);

        boolean[][] path = new boolean[size][size];

        for (int i = 0; i < edgeSize; i++) {
            String[] inputEdge = br.readLine().split(" ");
            int from = Integer.parseInt(inputEdge[0]);
            int to = Integer.parseInt(inputEdge[1]);

            path[from - 1][to - 1] = true;
        }

        findPaths(path);

        System.out.println(getResult(size, path));
    }
}

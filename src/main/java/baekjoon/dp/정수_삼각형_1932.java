package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 정수_삼각형_1932 {

    public static int calculateMaxPathSum(List<int[]> triangle) {

        List<int[]> memorization = triangle.stream()
                .map(row -> new int[row.length])
                .collect(Collectors.toList());

        memorization.get(0)[1] = triangle.get(0)[1];

        for (int i = 1; i < memorization.size(); i++) {
            for (int j = 1; j < memorization.get(i).length - 1; j++) {
                int[] parentRow = memorization.get(i - 1);
                int[] row = memorization.get(i);
                row[j] = Math.max(parentRow[j - 1], parentRow[j]) + triangle.get(i)[j];
            }
        }

        int[] lastRow = memorization.get(memorization.size() - 1);

        return Arrays.stream(lastRow)
                .max()
                .getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        List<int[]> triangle = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            triangle.add(new int[i + 3]);
            for (int j = 1; j < i + 2; j++) {
                int number = Integer.parseInt(st.nextToken());
                triangle.get(i)[j] = number;
            }
        }

        System.out.println(calculateMaxPathSum(triangle));
    }
}

package baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class 필터_1895 {

    public static int calculatePixelCount(int[][] arr, int target) {

        int count = 0;

        ArrayList<Integer> filter = new ArrayList<>();

        for (int row = 0; row < arr.length - 2; row++) {
            for (int col = 0; col < arr[0].length - 2; col++) {
                for (int filterRow = row; filterRow < row + 3; filterRow++) {
                    for (int filterCol = col; filterCol < col + 3; filterCol++) {
                        filter.add(arr[filterRow][filterCol]);
                    }
                }

                filter.sort(Comparator.naturalOrder());
                if (filter.get(4) >= target) {
                    count++;
                }

                filter.clear();
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rowColNumber = br.readLine().split(" ");

        int row = Integer.parseInt(rowColNumber[0]);
        int col = Integer.parseInt(rowColNumber[1]);

        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] rowNumber = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(rowNumber[j]);
            }
        }

        int target = Integer.parseInt(br.readLine());

        System.out.println(calculatePixelCount(arr, target));
    }
}

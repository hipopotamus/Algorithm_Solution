package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 밤양갱_31926 {

    public static int getTime(int target) {
        int dalCount = 1;
        int totalTime = 8;

        while (dalCount < target) {
            dalCount *= 2;
            totalTime++;
        }

        if (dalCount == target) {
            totalTime += 2;
        } else {
            totalTime++;
        }

        return totalTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        int totalTime = getTime(target);

        System.out.println(totalTime);
    }
}

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 군계일학_15966_다른풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] numbers = new int[size];
        HashMap<Integer, Integer> memorization = new HashMap<>();
        int max = 0;

        String[] numberInfo = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(numberInfo[i]);
        }


        for (int number : numbers) {
            memorization.put(number, memorization.getOrDefault(number - 1, 0) + 1);
            max = Math.max(max, memorization.get(number));
        }

        System.out.println(max);
    }
}

package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 과일_탕후루_30804 {

    public static int extractFruit(int reservedFruit1, int reservedFruit2, int[] tanghulu) {

        int maxLength = 0;
        int right = 0;
        int left = 0;

        while (left <= tanghulu.length) {

            if (left == tanghulu.length || (tanghulu[left] != reservedFruit1 && tanghulu[left] != reservedFruit2)) {
                int length = left - right;
                if (length > maxLength) {
                    maxLength = length;
                }

                right = left + 1;
                left++;
                continue;
            }

            if (tanghulu[left] == reservedFruit1 || tanghulu[left] == reservedFruit2) {
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] tanghulu = new int[size];
        Set<Integer> fruitSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            int fruit = Integer.parseInt(st.nextToken());
            tanghulu[i] = fruit;
            fruitSet.add(fruit);
        }

        List<Integer> fruitList = new ArrayList<>(fruitSet);
        int maxSize = 0;

        if (fruitList.size() <= 2) {
            System.out.println(tanghulu.length);
            return;
        }

        for (int i = 0; i < fruitList.size() - 1; i++) {
            for (int j = i + 1; j < fruitList.size(); j++) {
                int reservedFruit1 = fruitList.get(i);
                int reservedFruit2 = fruitList.get(j);

                int extractedTanghulu = extractFruit(reservedFruit1, reservedFruit2, tanghulu);

                if (extractedTanghulu > maxSize) {
                    maxSize = extractedTanghulu;
                }
            }
        }

        System.out.println(maxSize);
    }
}

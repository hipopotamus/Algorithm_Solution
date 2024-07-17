package baekjoon.dataStructure;

import java.io.*;
import java.util.StringTokenizer;

public class 주사위_세개_2480 {

    public static int priceCalculate(int firstDice, int secondDice, int thirdDice) {
        if (firstDice == secondDice & firstDice == thirdDice) {
            return 10000 + (1000 * firstDice);
        }
        if (firstDice != secondDice & firstDice != thirdDice & secondDice != thirdDice) {
            return 100 * Math.max(Math.max(firstDice, secondDice), thirdDice);
        }
        if (firstDice == secondDice || firstDice == thirdDice) {
            return 1000 + (100 * firstDice);
        }
        return 1000 + (100 * secondDice);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstDice = Integer.parseInt(st.nextToken());
        int secondDice = Integer.parseInt(st.nextToken());
        int thirdDice = Integer.parseInt(st.nextToken());

        int result = priceCalculate(firstDice, secondDice, thirdDice);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

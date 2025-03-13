package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gazzzua_17939 {

    public static int getMaxRevenue(int maxTime, int[] price) {
        int[] revenue = new int[price.length];
        int maxPrice = 0;

        for (int i = 1; i <= price.length; i++) {
            if (maxPrice < price[price.length - i]) {
                maxPrice = price[price.length - i];
                continue;
            }

            revenue[price.length - i] = maxPrice - price[price.length - i];
        }

        int revenueSum = Arrays.stream(revenue).sum();

        return revenueSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxTime = Integer.parseInt(br.readLine());
        int[] price = new int[maxTime];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < maxTime; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int maxRevenue = getMaxRevenue(maxTime, price);

        System.out.println(maxRevenue);
    }
}

package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 배_2853 {

    public static void checkMultiple(List<Integer> periods, int day) {
        for (int period : periods) {
            if (day % period == 0) {
                return;
            }
        }

        periods.add(day);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> periods = new ArrayList<>();

        br.readLine();

        for (int i = 0; i < size - 1; i++) {
            int day = Integer.parseInt(br.readLine()) - 1;
            checkMultiple(periods, day);
        }

        System.out.println(periods.size());
    }
}

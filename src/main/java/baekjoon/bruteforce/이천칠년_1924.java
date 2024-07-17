package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class 이천칠년_1924 {

    public static String calculateDay(int month, int day, int[] monthDays, String[] days) {
        int totalDays = day;
        for (int i = 1; i < month; i++) {
            totalDays += monthDays[i];
        }

        return days[totalDays % 7];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        String dayByString = calculateDay(month, day, monthDays, days);

        bw.write(dayByString);
        bw.flush();
    }
}

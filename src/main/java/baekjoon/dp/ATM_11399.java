package baekjoon.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

    private static int getTotalTime(int[] timeArr) {
        int[] totalTimeArr = new int[timeArr.length];
        totalTimeArr[0] = timeArr[0];

        for (int i = 1; i < totalTimeArr.length; i++) {
            totalTimeArr[i] = totalTimeArr[i - 1] + timeArr[i];
        }

        return Arrays.stream(totalTimeArr).sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] timeArr = new int[size];

        for (int i = 0; i < size; i++) {
            int time = Integer.parseInt(st.nextToken());
            timeArr[i] = time;
        }

        Arrays.sort(timeArr);

        int totalTime = getTotalTime(timeArr);

        bw.write(String.valueOf(totalTime));
        bw.flush();
    }
}

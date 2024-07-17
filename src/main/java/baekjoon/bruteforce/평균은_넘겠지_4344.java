package baekjoon.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 평균은_넘겠지_4344 {

    public static double calculateAboveAverage(List<Integer> scoreList) {
        int totalScore = scoreList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int averageScore = totalScore / scoreList.size();

        long aboveAverageNumber = scoreList.stream()
                .filter(score -> score > averageScore)
                .count();

        double aboveAveragePercent =  ((double) aboveAverageNumber / (double) scoreList.size()) * 100.0;
        return Math.round(aboveAveragePercent * 1000.0) / 1000.0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseSie = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseSie; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int scoreSize = Integer.parseInt(st.nextToken());
            List<Integer> scoreList = new ArrayList<>();

            for (int j = 0; j < scoreSize; j++) {
                scoreList.add(Integer.parseInt(st.nextToken()));
            }

            double aboveAveragePercent = calculateAboveAverage(scoreList);
            bw.write(String.format("%.3f", aboveAveragePercent) + "%");
            bw.newLine();
        }

        bw.flush();
    }
}

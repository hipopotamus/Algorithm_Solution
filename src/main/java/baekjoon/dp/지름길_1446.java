package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 지름길_1446 {

    public static class ShortCut {
        int start;
        int end;
        int distance;

        public ShortCut(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static int minDistance(int[] memorization, List<ShortCut>[] shortCuts) {

        for (int i = 1; i < memorization.length; i++) {

            memorization[i] = memorization[i - 1] + 1;

            if (shortCuts[i] != null) {
                for (ShortCut shortCut : shortCuts[i]) {
                    memorization[i] = Math.min(memorization[i], memorization[shortCut.start] + shortCut.distance);
                }
            }
        }

        return memorization[memorization.length - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int shortCutSize = Integer.parseInt(st.nextToken());
        int totalDistance = Integer.parseInt(st.nextToken());
        int[] memorization = new int[totalDistance + 1];
        List<ShortCut>[] shortCuts = new List[totalDistance + 1];

        for (int i = 0; i < shortCutSize; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            ShortCut shortCut = new ShortCut(start, end, distance);

            if (shortCut.end > totalDistance) {
                continue;
            }

            if (shortCuts[shortCut.end] == null) {
                shortCuts[shortCut.end] = new ArrayList<>();
            }

            shortCuts[shortCut.end].add(shortCut);
        }

        int minDistance = minDistance(memorization, shortCuts);

        System.out.println(minDistance);
    }
}

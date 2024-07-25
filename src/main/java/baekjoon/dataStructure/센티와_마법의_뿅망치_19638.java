package baekjoon.dataStructure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 센티와_마법의_뿅망치_19638 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int count = 0;
        String answer = "NO\n";
        int result = 0;

        int giantNumber = Integer.parseInt(st.nextToken());
        int sentiHeight = Integer.parseInt(st.nextToken());
        int hammerFrequency = Integer.parseInt(st.nextToken());

        for (int i = 0; i < giantNumber; i++) {
            int giantHeight = Integer.parseInt(br.readLine());
            queue.add(giantHeight);
        }

        if (queue.peek() < sentiHeight) {
            answer = "YES\n";
            result = count;
        } else {
            for (int i = 0; i < hammerFrequency; i++) {
                int halfGiantHeight;
                Integer maxGiantHeight = queue.poll();

                if (maxGiantHeight == 1) {
                    halfGiantHeight = maxGiantHeight;
                } else {
                    halfGiantHeight = maxGiantHeight / 2;
                }
                count++;
                queue.add(halfGiantHeight);

                Integer topGiantHeight = queue.peek();
                if (topGiantHeight < sentiHeight) {
                    answer = "YES\n";
                    result = count;
                    break;
                } else if (count == hammerFrequency) {
                    result = topGiantHeight;
                }

            }
        }

        sb.append(answer)
                .append(result);

        bw.write(sb.toString());
        bw.flush();
    }
}

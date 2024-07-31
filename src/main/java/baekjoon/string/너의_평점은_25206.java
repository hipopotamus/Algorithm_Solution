package baekjoon.string;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 너의_평점은_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Double> gradMap = new HashMap<>() {
            {
                put("A+", 4.5);
                put("A0", 4.0);
                put("B+", 3.5);
                put("B0", 3.0);
                put("C+", 2.5);
                put("C0", 2.0);
                put("D+", 1.5);
                put("D0", 1.0);
                put("F", 0.0);
            }
        };

        double sum = 0;
        double creditSum = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();

            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            sum += credit * gradMap.get(grade);
            creditSum += credit;
        }

        double gpa = sum / creditSum;

        bw.write(String.format("%.6f", gpa));
        bw.flush();
    }
}

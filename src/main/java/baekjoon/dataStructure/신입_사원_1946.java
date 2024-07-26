package baekjoon.dataStructure;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 신입_사원_1946 {

    public static class Grade {
        int documentGrade;
        int interviewGrade;

        public Grade(int documentGrade, int interviewGrade) {
            this.documentGrade = documentGrade;
            this.interviewGrade = interviewGrade;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int caseSize = Integer.parseInt(br.readLine());
        while (caseSize-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int count = 0;
            int comparisonGrade = size + 1;
            PriorityQueue<Grade> queue =
                    new PriorityQueue<>((g1, g2) -> Integer.compare(g1.documentGrade, g2.documentGrade));

            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int documentGrade = Integer.parseInt(st.nextToken());
                int interviewGrade = Integer.parseInt(st.nextToken());

                queue.offer(new Grade(documentGrade, interviewGrade));
            }

            while (!queue.isEmpty()) {
                Grade grade = queue.poll();
                if (comparisonGrade > grade.interviewGrade) {
                    comparisonGrade = grade.interviewGrade;
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

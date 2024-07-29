package baekjoon.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 신입_사원_1946 {

    //서류와 면접 순위의 정보를 담는 클래스
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
            //** 입력 시작
            int size = Integer.parseInt(br.readLine());
            int count = 0;
            int comparisonGrade = size + 1;
            //서류순위를 기준으로 내림차순으로 정렬한다.
            PriorityQueue<Grade> queue =
                    new PriorityQueue<>((g1, g2) -> Integer.compare(g1.documentGrade, g2.documentGrade));

            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int documentGrade = Integer.parseInt(st.nextToken());
                int interviewGrade = Integer.parseInt(st.nextToken());

                queue.offer(new Grade(documentGrade, interviewGrade));
            }
            //** 입력 끝

            //서류 순위 대로 사람을 뽑는다.
            //뽑힌 사람의 면접 순위가 그 이전에 합격한 사람의 면접 순위 보다 낮다면 합격시킨다.
            while (!queue.isEmpty()) {
                Grade grade = queue.poll();
                if (comparisonGrade > grade.interviewGrade) {
                    comparisonGrade = grade.interviewGrade;
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        //출력
        bw.write(sb.toString());
        bw.flush();
    }
}

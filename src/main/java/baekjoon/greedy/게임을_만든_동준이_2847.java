package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 게임을_만든_동준이_2847 {

    //가장 높은 난이도 부터 탐색
    //현재 레벨의 점수가 한단계 높은 레벨의 점수보다 높으면 낮춰준다.
    public static int getFixCount(int[] scoreArr) {

        int count = 0;

        for (int i = 2; i <= scoreArr.length; i++) {
            int score = scoreArr[scoreArr.length - i];
            int afterScore = scoreArr[scoreArr.length - i + 1];

            if (score >= afterScore) {
                scoreArr[scoreArr.length - i] = afterScore - 1;
                count += score - afterScore + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] scoreArr = new int[size];

        for (int i = 0; i < size; i++) {
            scoreArr[i] = Integer.parseInt(br.readLine());
        }

        int fixCount = getFixCount(scoreArr);

        System.out.println(fixCount);
    }
}

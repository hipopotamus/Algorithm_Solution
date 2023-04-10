package programmers.dp;

import org.junit.jupiter.api.Test;

class 프로그래머스_dpTest {

    @Test
    public void 정수_삼각형Test() {
        정수_삼각형 test = new 정수_삼각형();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(test.solution(triangle));
    }

    @Test
    public void 등굣길Test() {
        등굣길 test = new 등굣길();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        int solution = test.solution(m, n, puddles);
        System.out.println(solution);
    }

}
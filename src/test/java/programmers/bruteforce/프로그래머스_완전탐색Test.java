package programmers.bruteforce;

import org.junit.jupiter.api.Test;

class 프로그래머스_완전탐색Test {

    @Test
    public void 피로도Test() {

        피로도 test = new 피로도();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int solution = test.solution(k, dungeons);
        System.out.println(solution);
    }

    @Test
    public void 전력망을_돌로_나누가Test() {

        전력망을_돌로_나누기 test = new 전력망을_돌로_나누기();
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int solution = test.solution(n, wires);
        System.out.println(solution);
    }

    @Test
    public void 모음사전Test() {

        모음사전 test = new 모음사전();
        String word = "EIO";
        int solution = test.solution(word);
        System.out.println(solution);
    }
}
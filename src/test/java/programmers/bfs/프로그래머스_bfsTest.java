package programmers.bfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class 프로그래머스_bfsTest {

    @Test
    public void solutionTest() {
        순위 solution = new 순위();

        int[][] results = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int solution1 = solution.solution(5, results);
        System.out.println(solution1);
    }

    @Test
    public void 게임_맵_최단거리Test() {
        게임_맵_최단거리 test = new 게임_맵_최단거리();
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int solution = test.solution(maps);
        System.out.println(solution);
    }

    @Test
    public void 여행경로Test() {
        여행경로 test = new 여행경로();
        String[][] tickets = {{"ICN", "JFK"}, {"ICN", "AAD"}, {"JFK", "ICN"}};
        String[] solution = test.solution(tickets);
        System.out.println(Arrays.toString(solution));
    }
}
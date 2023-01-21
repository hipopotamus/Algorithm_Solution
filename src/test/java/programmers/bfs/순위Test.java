package programmers.bfs;

import org.junit.jupiter.api.Test;

class 순위Test {

    @Test
    public void solutionTest() {
        순위 solution = new 순위();

        int[][] results = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int solution1 = solution.solution(5, results);
        System.out.println(solution1);
    }
}
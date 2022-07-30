package solution;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void solutionTest() {
        Solution solution = new Solution();

        int[][] results = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int solution1 = solution.solution(5, results);
        System.out.println(solution1);
    }
}
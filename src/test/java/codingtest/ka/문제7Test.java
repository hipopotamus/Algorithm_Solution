package codingtest.ka;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class 문제7Test {

    @Test
    public void solutionTest() {
        문제7 solutionClass = new 문제7();
        int[][] edges = {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}};
        int[] target = {0, 0, 0, 3, 0, 0, 5, 1, 2, 3};
        int[] solution = solutionClass.solution(edges, target);

        System.out.println(Arrays.toString(solution));

    }
}
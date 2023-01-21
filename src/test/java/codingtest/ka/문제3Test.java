package codingtest.ka;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class 문제3Test {

    @Test
    public void solutionTest() {
        문제3 solution = new 문제3();
        int[][] users1 = {{40, 10000}, {25, 10000}};
        int[] emoticons1 = {7000, 9000};

        int[][] users2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900},
                {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = {1300, 1500, 1600, 4900};

        System.out.println(Arrays.toString(solution.solution(users1, emoticons1)));
        System.out.println(Arrays.toString(solution.solution(users2, emoticons2)));
    }
}
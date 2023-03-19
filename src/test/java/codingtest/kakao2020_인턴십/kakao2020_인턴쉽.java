package codingtest.kakao2020_인턴십;

import org.junit.jupiter.api.Test;

class kakao2020_인턴쉽 {

    @Test
    public void 키패드_누르기() {
        키패드_누르기 test = new 키패드_누르기();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String solution = test.solution(numbers, hand);
        System.out.println(solution);
    }

    @Test
    public void 수식_최대화() {
        수식_최대화 test = new 수식_최대화();
        String expression = "100-200*300-500+20";
        long solution = test.solution(expression);
        System.out.println(solution);
    }

    @Test
    public void 경주로_건설() {
        경주로_건설 test = new 경주로_건설();
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};
        int solution = test.solution(board);
        System.out.println(solution);
    }
}
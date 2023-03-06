package codingtest.kakao2019_겨울_인턴쉽;

import org.junit.jupiter.api.Test;

import java.util.List;

class kakao2019_겨울_인턴십_Test {
    @Test
    public void 크레인_인형뽑기_게임_Test() {
        크레인_인형뽑기_게임 test = new 크레인_인형뽑기_게임();

        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int solution = test.solution(board, moves);
        System.out.println(solution);
    }

    @Test
    public void 튜플_Test() {
        튜플 test = new 튜플();
        String s = "{{20,111},{111}}";
        List<List<Integer>> parsing = test.parsing(s);
        System.out.println(parsing);
//        int[] solution = test.solution(s);
//        Arrays.stream(solution).forEach(System.out::print);
    }

    @Test
    public void 불량_사용자_Test() {
        불량_사용자 test = new 불량_사용자();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int solution = test.solution(user_id, banned_id);
        System.out.println(solution);
    }

    @Test
    public void 징검다리_건너기_Test() {
        징검다리_건너기 test = new 징검다리_건너기();
        int[] stones = {5};
        int k = 1;
        int solution = test.solution(stones, k);
        System.out.println(solution);
    }

}
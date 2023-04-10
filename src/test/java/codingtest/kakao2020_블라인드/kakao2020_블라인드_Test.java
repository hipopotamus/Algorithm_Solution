package codingtest.kakao2020_블라인드;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class kakao2020_블라인드_Test {

    @Test
    public void 자물쇠와_열쇠() {
        자물쇠와_열쇠 test = new 자물쇠와_열쇠();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        boolean solution = test.solution(key, lock);
        System.out.println(solution);
    }

}
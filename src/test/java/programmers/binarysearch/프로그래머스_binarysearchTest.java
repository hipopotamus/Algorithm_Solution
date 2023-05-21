package programmers.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 프로그래머스_binarysearchTest {

    @Test
    public void 입국심사Test() {
        입국심사 test = new 입국심사();
        int n = 6;
        int[] times = {7, 10};
        long solution = test.solution(n, times);
        System.out.println(solution);
    }
}
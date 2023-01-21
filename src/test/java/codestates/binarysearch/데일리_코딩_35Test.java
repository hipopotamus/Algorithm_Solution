package codestates.binarysearch;

import codestates.sort.데일리_코딩_35;
import org.junit.jupiter.api.Test;

class 데일리_코딩_35Test {

    @Test
    public void solutionTest() {
        데일리_코딩_35 solution = new 데일리_코딩_35();
        int[] output = solution.quickSort(new int[]{1, 2, 43, 100, 21});
        System.out.println(output);
    }
}
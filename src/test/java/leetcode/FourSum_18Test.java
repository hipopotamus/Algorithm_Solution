package leetcode;

import leetcode.twofactor.FourSum_18;
import org.junit.jupiter.api.Test;

import java.util.List;

class FourSum_18Test {

    @Test
    public void solutionTest() {
        FourSum_18 solution = new FourSum_18();

        int[] nums = {0, 0, 0, 0, 0};
        List<List<Integer>> lists = solution.fourSum(nums, 0);

        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.println("");
        }
    }
}
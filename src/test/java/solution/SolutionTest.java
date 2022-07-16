package solution;

import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    @Test
    public void solutionTest() {
        Solution solution = new Solution();

        int[] nums = {0, 0, 0, 0, 0};
        List<List<Integer>> lists = solution.fourSum(nums, 0);

        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.println("");
        }
    }
}
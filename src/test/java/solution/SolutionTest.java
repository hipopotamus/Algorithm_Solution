package solution;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void solutionTest() {
        Solution solution = new Solution();
        int[] output = solution.quickSort(new int[]{1, 2, 43, 100, 21});
        System.out.println(output);
    }
}
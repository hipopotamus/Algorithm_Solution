package solution;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void solutionTest() {
        Solution solution = new Solution();
        Assertions.assertThat(solution.largestProductOfThree(new int[]{-5, -4, -3, -2, -1})).isEqualTo(-6);
        Assertions.assertThat(solution.largestProductOfThree(new int[]{-50, -20, -30, -5, 40})).isEqualTo(60000);
        Assertions.assertThat(solution.largestProductOfThree(new int[]{2, 11, 13, 7, 13, 3, 11, 5})).isEqualTo(1859);
        Assertions.assertThat(solution.largestProductOfThree(new int[]{11, 7, 5, 3, 2})).isEqualTo(385);
        Assertions.assertThat(solution.largestProductOfThree(new int[]{-5, -4, -3, -1, 999, 10000})).isEqualTo(200000);
        Assertions.assertThat(solution.largestProductOfThree(new int[]{2, 3, -11, 7, 5, -13})).isEqualTo(1001);
        Assertions.assertThat(solution.largestProductOfThree(new int[]{7, 5, 7})).isEqualTo(245);
        Assertions.assertThat(solution.largestProductOfThree(new int[]{0, 2, 3})).isEqualTo(0);
    }
}
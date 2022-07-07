package solution;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {

    @Test
    void threeSumClosest() {
        Solution solution = new Solution();
        int [] testArray1 = {0, 0, 0};
        int [] testArray2 = {-1,2,1,-4};
        int result1 = solution.threeSumClosest(testArray1, 1);
        int result2 = solution.threeSumClosest(testArray2, 1);

        Assertions.assertThat(result1).isEqualTo(0);
        Assertions.assertThat(result2).isEqualTo(2);
    }
}
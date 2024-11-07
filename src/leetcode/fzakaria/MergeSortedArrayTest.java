package leetcode.fzakaria;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortedArrayTest {

    @Test
    public void basicTest() {
        int[] lhs = new int[]{1, 2, 3, 0, 0, 0};
        int[] rhs = new int[]{2, 5, 6};
        MergeSortedArray.merge(lhs, 3, rhs, 3);
        assertThat(lhs).containsExactly(1, 2, 2, 3, 5, 6);
    }

    @Test
    public void advancedTest() {
        int[] lhs = new int[]{4, 5, 6, 0, 0, 0};
        int[] rhs = new int[]{1, 2, 3};
        MergeSortedArray.merge(lhs, 3, rhs, 3);
        assertThat(lhs).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void failingTest() {
        int[] lhs = new int[]{4, 0, 0, 0, 0, 0};
        int[] rhs = new int[]{1, 2, 3, 5, 6};
        MergeSortedArray.merge(lhs, 1, rhs, 5);
        assertThat(lhs).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void failingTestAgain() {
        int[] lhs = new int[]{1, 2, 4, 5, 6, 0};
        int[] rhs = new int[]{3};
        MergeSortedArray.merge(lhs, 5, rhs, 1);
        assertThat(lhs).containsExactly(1, 2, 3, 4, 5, 6);
    }
}

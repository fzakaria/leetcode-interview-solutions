package leetcode.mrw;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortedArrayTest {

    @Test
    public void testIt() {
        int[] nums1 = {1, 1, 2, 0, 0, 0};
        int[] nums2 = {1, 2, 3};

        MergeSortedArray.merge(nums1, 3, nums2, 3);
        assertThat(nums1).isEqualTo(new int[]{1, 1, 1, 2, 2, 3});
    }
}

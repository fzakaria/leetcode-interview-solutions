package leetcode.fzakaria;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RemoveElementTest {

    @Test
    public void basicTest() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElement.removeElement(nums, 2);
        assertThat(nums).endsWith(2, 2, 2);
    }

}

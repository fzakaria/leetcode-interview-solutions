package leetcode.mrw;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class MajorityElement {
    public static int majorityElement(int[] nums) {
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        Optional<Map.Entry<Integer, Integer>> majority = counts.entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length / 2)
                .findFirst();
        if (majority.isEmpty()) {
            throw new RuntimeException();
        }
        return majority.get().getKey();
    }
}


@RunWith(Parameterized.class)
public record MajorityElementTest(Case testCase) {
    public record Case(int[] nums, int majority) {}

    @Parameterized.Parameters
    public static List<Case> parameters() {
        return Arrays.asList(
                new Case(new int[]{3, 2, 3}, 3),
                new Case(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }

    @Test
    public void testIt() {
        Assertions.assertThat(MajorityElement.majorityElement(testCase.nums)).isEqualTo(testCase.majority);
    }
}

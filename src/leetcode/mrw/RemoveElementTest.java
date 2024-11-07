package leetcode.mrw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class RemoveElementTest {
    public record Case (int[] input, int remove, int[] output) {}

    @Parameterized.Parameters
    public static Collection<Case> cases() {
        return Arrays.asList(
                new Case(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                new Case(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 0, 1, 3, 4}),
                new Case(new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2}, 4, new int[]{0, 0, 0, 2}));
    }

    private Case testCase;

    public RemoveElementTest(Case testCase) {
        this.testCase = testCase;
    }

    @Test
    public void testIt() {
        final int[] input = Arrays.copyOf(testCase.input, testCase.input.length);
        final int n = RemoveElement.remove(input, testCase.remove);
        assertThat(testCase.output.length).isEqualTo(n);

        final int[] output = Arrays.copyOf(input, n);
        Arrays.sort(output);
        assertThat(testCase.output).isEqualTo(output);
    }
}

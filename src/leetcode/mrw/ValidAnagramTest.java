package leetcode.mrw;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        final char[] sc = new char[26];
        final char[] tc = new char[26];

        for (char c : s.toCharArray()) {
            sc[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            tc[c - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }

        return true;
    }
}

@RunWith(Parameterized.class)
public record ValidAnagramTest(Case testCase) {
    public record Case(String s, String t, boolean anagram) {}

    @Parameterized.Parameters
    public static List<Case> parameters() {
        return Arrays.asList(
                new Case("anagram", "nagaram", true),
                new Case("rat", "car", false)
        );
    }

    @Test
    public void testIt() {
        Assertions.assertThat(ValidAnagram.isAnagram(testCase.s, testCase.t)).isEqualTo(testCase.anagram);
    }
}

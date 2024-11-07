package leetcode.mrw;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        final char[] nLetters = new char[26];
        final char[] mLetters = new char[26];

        for (char c : ransomNote.toCharArray()) {
            nLetters[c - 'a'] += 1;
        }

        for (char c : magazine.toCharArray()) {
            mLetters[c - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (nLetters[i] > mLetters[i]) {
                return false;
            }
        }

        return true;
    }
}

@RunWith(Parameterized.class)
public record RansomNoteTest(Case testCase) {
    public record Case(String note, String magazine, boolean canConstruct) {}

    @Parameterized.Parameters
    public static List<Case> parameters() {
        return Arrays.asList(
                new Case("a", "b", false),
                new Case("aa", "ab", false),
                new Case("aa", "aab", true)
        );
    }

    @Test
    public void testIt() {
        Assertions.assertThat(RansomNote.canConstruct(testCase.note, testCase.magazine))
                .isEqualTo(testCase.canConstruct);
    }
}

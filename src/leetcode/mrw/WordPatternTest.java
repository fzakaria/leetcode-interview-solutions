package leetcode.mrw;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        final Map<Character, String> p2w = new HashMap<>();
        final Map<String, Character> w2p = new HashMap<>();
        final String[] words = s.split("\\s+");
        if (pattern.length() != words.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            final char p = pattern.charAt(i);
            final String w = words[i];
            if (!p2w.containsKey(p)) {
                p2w.put(p, w);
            }
            if (!w2p.containsKey(w)) {
                w2p.put(w, p);
            }
            if (!p2w.get(p).equals(w) || w2p.get(w) != p) {
                return false;
            }
        }
        return true;
    }
}

@RunWith(Parameterized.class)
public record WordPatternTest(Case testCase) {
    public record Case(String pattern, String words, boolean matches) {}

    @Parameterized.Parameters
    public static List<Case> parameters() {
        return Arrays.asList(
                new Case("abba", "dog cat cat dog", true),
                new Case("abba", "dog cat cat fish", false),
                new Case("aaaa", "dog cat cat dog", false),
                new Case("abba", "dog dog dog dog", false)
        );
    }

    @Test
    public void testIt() {
        Assertions.assertThat(WordPattern.wordPattern(testCase.pattern, testCase.words)).isEqualTo(testCase.matches);
    }
}


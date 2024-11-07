package leetcode.mrw;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            final char[] code = new char[26];
            for (char c : s.toCharArray()) {
                code[c - 'a']++;
            }
            final String key = new String(code);
            final List<String> group = groups.getOrDefault(key, new ArrayList<>());
            group.add(s);
            groups.put(key, group);
        }

        // side effectful peek is gross but it makes the test stable
        return groups.values().stream().peek(
                value -> value.sort(Comparator.naturalOrder())
        ).toList();
    }
}

public class GroupAnagramsTest {

    @Test
    public void testMany() {
        List<List<String>> grouped = GroupAnagrams.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        );

        Assertions.assertThat(grouped).containsOnlyOnce(List.of("bat"));
        Assertions.assertThat(grouped).containsOnlyOnce(List.of("nat", "tan"));
        Assertions.assertThat(grouped).containsOnlyOnce(List.of("ate", "eat", "tea"));
    }

    @Test
    public void testEdges() {
        Assertions.assertThat(GroupAnagrams.groupAnagrams(new String[]{""}))
                .isEqualTo(List.of(List.of("")));
        Assertions.assertThat(GroupAnagrams.groupAnagrams(new String[]{"a"}))
                .isEqualTo(List.of(List.of("a")));
    }
}

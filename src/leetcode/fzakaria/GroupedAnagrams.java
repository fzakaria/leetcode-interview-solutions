package leetcode.fzakaria;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupedAnagrams {

    public List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramToWords = Arrays.stream(words)
                .collect(Collectors.groupingBy(GroupedAnagrams::sort));
        return anagramToWords.values().stream().toList();
    }

    private static String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

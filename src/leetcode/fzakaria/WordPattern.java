package leetcode.fzakaria;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @link https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {

        Map<String, String> letterToWord = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        for (String word : words) {

            String letter = pattern.substring(0, 1);
            pattern = pattern.substring(1);

            if (!letterToWord.containsKey(letter)) {

                if (!letterToWord.containsValue(word)) {
                    letterToWord.put(letter, word);
                    continue;
                }

                return false;
            }

            if (!letterToWord.get(letter).equals(word)) {
                return false;
            }
        }
        return true;
    }

}

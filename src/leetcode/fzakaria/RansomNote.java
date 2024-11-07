package leetcode.fzakaria;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        // construct a frequency map for magazine
        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        // iterate through every letter of ransomNote
        // and make sure we have enough letters in our frequency map
        for (char c : ransomNote.toCharArray()) {
            if (freq[c - 'a'] == 0) {
                return false;
            }
            freq[c - 'a']--;
        }

        return true;
    }

}

package 綜合;

import java.util.Objects;

/**
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 * 
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 * 
 * Input: word1 = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 * 
 * 重點整理
 * Objects.equals(s1.toString(), s2.toString())
 */
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String word : word1) {
            s1.append(word);
        }
        for (String word : word2) {
            s2.append(word);
        }
        return Objects.equals(s1.toString(), s2.toString());
    }
}

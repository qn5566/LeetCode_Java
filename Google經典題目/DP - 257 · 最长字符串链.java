package Google經典題目;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 时间复杂度：O(n^2m), n为字符串个数，m为字符串长度，在寻找第i个单词为词链结尾时的前一个单词j时，需要两层循环，故为n^2n
 * 空间复杂度：O(n),一个dp[n]记录所有词为词链结尾时的最长长度
 */
class Solution {
    /**
     * @param words: the list of word.
     * @return: the length of the longest string chain.
     */
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        int ans = 0;

        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++)
                if (pre_word(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
        }
        return ans + 1;
    }

    private boolean pre_word(String a, String b) {
        if (a.length() + 1 != b.length())
            return false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == a.length())
            return true;
        return false;
    }
}

package TowPoint雙指針;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 給一個英文字串，將裡面的母音字母反轉。
 * 範例1:
 * Given s = "hello", return "holle".
 * 範例2：
 * Given s = "leetcode", return "leotcede".
 * 
 * 注意： y不算在母音字母中。
 * 
 * 
 * 时间复杂度为 O(N)：只需要遍历所有元素一次
 * 空间复杂度 O(1)：只需要使用两个额外变量
 */
class Solution {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I',
                    'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null)
            return null;
        int i = 0;
        int j = s.length() - 1;

        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}

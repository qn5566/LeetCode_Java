package 綜合;

/**
 * ex1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * ex2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * 
 * 使用滑動窗口
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 统计s1中所有字母数量
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        // 定义左右指针
        int left = 0, right = 0;
        while (left < s2.length() && right < s2.length()) {
            // 当前字符
            int c = s2.charAt(right) - 'a';
            // 当前字符数量减一
            count[c]--;
            // 如果当前数量为0
            if (count[c] == 0) {
                // 区间长度正好等于s1长度时，说明完全匹配，返回true
                if (right - left + 1 == s1.length())
                    return true;
            } else if (count[c] < 0) { // 如果当前数量小于0
                // 移动左指针
                while (left <= right) {
                    // 左指针字符
                    int leftChar = s2.charAt(left++) - 'a';
                    // 左指针字符数量加一
                    count[leftChar]++;
                    // 左右指针字符相同时，结束移动左指针
                    if (leftChar == c) {
                        break;
                    }
                }
            }
            right++; // 右指针加一
        }
        return false;
    }
}
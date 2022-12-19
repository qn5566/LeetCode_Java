package DP.最长公共子序列;

/**
 * 求兩個字串相同之長度
 * 
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 定義 dp 可以存 兩個字串相同的資料
 * 
 * 可以畫 2 維圖解釋
 * 
 * 0 a b c d e
 * a 1 1 1 1 1
 * c 1 1 2 2 2
 * e 1 1 2 2 3
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}

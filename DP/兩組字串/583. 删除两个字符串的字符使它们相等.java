package DP.兩組字串;

/**
 * S :O(m*n)
 * T :O(m*n)
 * 
 * 
 * 求出最長的字串長度
 * 再拿來把它剪去 m+n
 * 因為兩個字串長度的總和相減可以知道他們差多少
 * 且因為有2組文字 所以乘2
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return m + n - 2 * dp[m][n];

    }
}

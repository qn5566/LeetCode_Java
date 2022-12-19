package DP.兩組字串;

/**
 * 修改一个字符串成为另一个字符串，使得修改次数最少。一次修改操作包括：插入一个字符、删除一个字符、替换一个字符。
 * 對題目來說 所以操作都是增加1次
 * 所以我們可以畫圖
 * 拿題目的 "horse" 和 "ros" 做比較
 * 方法是表叫最小的
 * 如果有相同的字 就不用操作
 * 沒有的話要+1
 * 
 * x = "hrose", y = "ros"
 * 0 1 2 3 4 5
 * 1 1 2 2 3 4
 * 2 2 1 2 3 4
 * 3 3 2 2 2 3
 * 
 * dp[m][n] = 3;
 */
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}

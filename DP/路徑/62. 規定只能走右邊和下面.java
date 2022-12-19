package DP.路徑;

import java.util.Arrays;

/**
 * 經典機器人走路
 * 把他變成一位正列 ( m + n )
 * 
 * dp 公式
 * dp[i] = dp[i] + dp[i - 1];
 * 
 * 每次走到的路徑總數 會等於 上面和左邊相加
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        // 因為每一步都是1 所以用 基底用1去做
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}

/**
 * 二維算法
 */
class Solution_two_dim {
    public int helper(int i, int j, int[][] dp) {
        if (i >= 0 && j >= 0 && dp[i][j] != 0)
            return dp[i][j];
        if (i == 0 && j == 0)
            return 1;
        if (i < 0)
            return 0;
        if (j < 0)
            return 0;
        int x = helper(i - 1, j, dp);
        int y = helper(i, j - 1, dp);
        dp[i][j] = x + y;
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m - 1, n - 1, dp);
    }
}

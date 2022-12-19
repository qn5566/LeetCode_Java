package DP;

/**
 * DP 求matrix裡的最小值
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        int len = A.length;
        if (len == 0)
            return 0;
        int[][] dp = new int[len][len];

        // 先把最上面的row赴值
        for (int i = 0; i < len; i++) {
            dp[0][i] = A[0][i];
        }

        // 從1開始是因為row 0 沒有值
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][j];

                // 左邊邊線的
                if (j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                // 右邊邊線的
                if (j + 1 < len)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);

                // 正常情況
                dp[i][j] += A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++)
            res = Math.min(res, dp[len - 1][i]);
        return res;
    }
}
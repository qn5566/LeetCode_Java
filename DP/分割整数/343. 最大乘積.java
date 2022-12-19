package DP.分割整数;

/**
 * For example, given n = 2,
 * return 1
 * (2 = 1 + 1); given n = 10, return 36
 * (10 = 3 + 3 + 4).
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        // 前面0~2基本先定義好
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int curMaxProduct = Math.max(dp[i - j], i - j);
                dp[i] = Math.max(dp[i], curMaxProduct * j);
            }
        }
        return dp[n];
    }
}

// 或是用dfs
class Solution_dfs {
    Integer[] cache;

    public int integerBreak(int n) {
        cache = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n < 2) {
            return 0;
        }

        if (cache[n] != null) {
            return cache[n];
        }

        int maxProductForN = 0;
        for (int i = 1; i < n; i++) {
            int curMaxProduct = Math.max(dfs(n - i), n - i);
            maxProductForN = Math.max(curMaxProduct * i, maxProductForN);
        }
        cache[n] = maxProductForN;
        return maxProductForN;
    }
}

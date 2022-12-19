package DP.背包;

/**
 * dp 儲存可以排列組合的數量之總數
 * 完全背包问题，使用 dp 记录可达成目标的组合数目。
 * 注意：這一題是算有幾種
 * 所以公式是 dp[i] += dp[i - coin];
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * 畫圖
 * 0 1 2 3 4 5
 * 1 1 2 2 3 4
 */
class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

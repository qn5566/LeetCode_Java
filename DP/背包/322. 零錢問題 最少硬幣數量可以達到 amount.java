package DP.背包;

/**
 * 零錢問題
 * 
 * 主要尋找最少硬幣數量可以達到 amount
 * 
 * 畫圖
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * 0 1 2 3 4 5 6 7 8 9 10 11
 * 0 1 1 2 2 1 2 2 3 3 2 3
 * 
 * 可以用初始值 dp[i] = 0 來判斷是不是第一次訪問
 * 第一次訪問的時候 dp[i] = dp[i - coin] + 1;
 * 第二次訪問的時候 Math.min(dp[i], dp[i - coin] + 1);
 * 
 * return 3 (11 = 5 + 5 + 1)
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null)
            return 0;
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { // 将逆序遍历改为正序遍历
                if (i == coin) {
                    dp[i] = 1;

                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    // 要避免dp[i] =0 的時候，所以要分別判斷
                    dp[i] = dp[i - coin] + 1;

                } else if (dp[i - coin] != 0) {

                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}

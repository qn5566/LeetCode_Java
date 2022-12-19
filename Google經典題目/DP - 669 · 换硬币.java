package Google經典題目;

import java.util.Arrays;

/**
 * 
 * F(1)=min(F(1-1),F(1-2),F(1-5))+1=1F(1)=min(F(1−1),F(1−2),F(1−5))+1=1
 * 时间复杂度：O(Sn)O(Sn)，其中 SS 是金额，nn 是面额数。我们一共需要计算 O(S) 个状态
 * 空间复杂度：O(S)O(S)。数组 \textit{dp}dp 需要开长度为总金额 SS 的空间
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
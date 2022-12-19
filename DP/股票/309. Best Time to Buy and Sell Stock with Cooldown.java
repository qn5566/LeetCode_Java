package DP.股票;

/**
 * 增加一 cd 時間
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int withShare = -prices[0];
        int cooldown = 0;
        int noShare = 0;

        for (int i = 0; i < n; i++) {
            withShare = Math.max(withShare, cooldown - prices[i]);
            cooldown = Math.max(cooldown, noShare);
            noShare = Math.max(noShare, withShare + prices[i]);
        }

        return noShare;
    }
}

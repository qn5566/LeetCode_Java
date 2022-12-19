package DP.股票;

/**
 * 可以買兩張的股票的情況之下
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int noShare_1 = 0;
        int withShare_1 = -prices[0];
        int noShare_2 = 0;
        int withShare_2 = -prices[0];

        for (int i = 1; i < n; i++) {
            withShare_1 = Math.max(withShare_1, -prices[i]);
            noShare_1 = Math.max(noShare_1, withShare_1 + prices[i]);
            withShare_2 = Math.max(withShare_2, noShare_1 - prices[i]);
            noShare_2 = Math.max(noShare_2, withShare_2 + prices[i]);

        }
        return Math.max(noShare_1, noShare_2);
    }
}

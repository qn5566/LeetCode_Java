package DP.股票;

/**
 * 無限制交易次數
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and
 * sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6),
 * profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int[][] dp = new int[n][2];
        // 狀態有兩種
        // 第一種有股票
        // 第二種沒股票
        // dp[i][0] = noShare
        // dp[i][1] = withShare
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 返回最後一天
        return dp[n - 1][0];
    }
}

/**
 * 另外一種寫法
 */
class Solution_2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int noShare = 0;
        int withShare = -prices[0];

        for (int i = 1; i < n; i++) {
            noShare = Math.max(noShare, withShare + prices[i]);
            withShare = Math.max(withShare, noShare - prices[i]);

        }
        return noShare;
    }
}
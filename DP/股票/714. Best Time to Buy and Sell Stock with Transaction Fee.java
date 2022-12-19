package DP.股票;

/**
 * hold 昨天的 hold 跟 昨天的sold 的$$買進今天的價錢比
 * sold 昨天賣的價錢跟昨天持有的hold到今天賣掉再減去手續費
 * 
 * t O(n)
 * s O(1)
 * 
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = Integer.MIN_VALUE / 2, sold = 0;

        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            int hold2 = hold;
            int sold2 = sold;

            hold = Math.max(hold2, sold - p);
            sold = Math.max(sold2, hold + p - fee);
        }
        return sold;
    }
}

/**
 * 另外一種寫法
 */
class Solution_2 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0)
            return 0;

        int noShare = 0;
        int withShare = -prices[0];

        for (int i = 1; i < n; i++) {
            noShare = Math.max(noShare, withShare + prices[i] - fee);
            withShare = Math.max(withShare, noShare - prices[i]);

        }
        return noShare;
    }
}

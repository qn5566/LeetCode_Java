package DP.股票;

/**
 * 一个视频解决所有Best Time to Buy and Sell Stock问题
 * https://www.youtube.com/watch?v=USEFjOtuyA4&ab_channel=happygirlzt
 * 
 * 你得到一個數組prices，其中prices[i]是當天給定股票的價格。i
 * 您希望通過選擇一天購買一隻股票並選擇未來的另一天出售該股票來最大化您的利潤。
 * 返還您可以從此交易中獲得的最大利潤。如果您無法獲得任何利潤，請退貨0。
 * 
 * 題目求說要取的裡面差異最大的值
 * 先計算res的值之後才可以更新最小值
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
 * profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed
 * because you must buy before you sell.
 * 
 * 輸入： prices = [7,6,4,3,1]
 * 輸出： 0
 * 解釋：在這種情況下，沒有交易完成，最大利潤 = 0。
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}

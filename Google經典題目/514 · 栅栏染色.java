package Google經典題目;

/**
 * 思路
 * 標準DP公式
 * dp[i]=(k-1)×(dp[i-1]+dp[i-2])
 * dp[i-1]×(k-1)代表当前格子的颜色和前一个不同的方案
 * dp[i-2]×(k-1)代表当前格子的颜色和前一个相同的方案
 */
class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        int[] dp = new int[3];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            // k - 1的情况下和上一个不同， 1情况和上一个相同， 上一个相同情况下， 上上个可以选k - 1种
            dp[i % 3] = (k - 1) * dp[(i - 1) % 3] + (k - 1) * dp[(i - 2) % 3];
        }
        return dp[(n - 1) % 3];
    }
}

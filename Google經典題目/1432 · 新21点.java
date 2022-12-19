package Google經典題目;

/**
 * 根据规则，当分数达到或超过 k 时游戏结束，游戏结束时，如果分数不超过 n 则获胜，
 * 如果分数超过 n 则失败。因此当 k≤x≤min(n,k+w−1) 时有 dp[x]=1，当 x>min(n,k+w−1) 时有 dp[x]=0
 */
class Solution {
    public double new21Game(int n, int k, int w) {
        if (k == 0) {
            return 1.0;
        }
        double[] dp = new double[k + w];
        for (int i = k; i <= n && i < k + w; i++) {
            dp[i] = 1.0;
        }
        for (int i = k - 1; i >= 0; i--) {
            for (int j = 1; j <= w; j++) {
                dp[i] += dp[i + j] / w;
            }
        }
        return dp[0];
    }
}

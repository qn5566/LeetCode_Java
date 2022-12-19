package DP.分割整数;

/**
 * 關鍵有兩個地方
 * 1. 如果不是0才能算 dp[i+1] = dp[i+1] + dp[i];
 * 2. 如果是兩位數 10 >= && <= 26
 * dp[i+1] = dp[i+1] + dp[i-1] // 直接加上一個 因為單個的上面已經加好了
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }

            int num = Integer.valueOf(s.substring(i - 1, i + 1));
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}

class Solution_2 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
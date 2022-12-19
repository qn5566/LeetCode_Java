package DP.背包;

/**
 * 
 * 这道题是一道典型的应用DP来解的题，重中之重就是在于找出递推式。
 * 如果你第一反应没有想到用DP来做，遇到0或者1就将对应的m和n的值减小，这种方法在有的时候是不对的，
 * 比如对于{"11","01","10"}，m=2，n=2这个例子，
 * 我们将遍历完“11”的时候，把1用完了，那么对于后面两个字符串就没法处理了，
 * 而其实正确的答案是应该组成后面两个字符串才对。
 * 
 * 所以我们需要建立一个二维的DP数组，其中dp[i][j]表示有i个0和j个1时能组成的最多字符串的个数，
 * 而对于当前遍历到的字符串，我们统计出其中0和1的个数为zeros和ones，然后dp[i - zeros][j -
 * ones]表示当前的i和j减去zeros和ones之前能拼成字符串的个数，
 * 那么加上当前的zeros和ones就是当前dp[i][j]可以达到的个数，
 * 我们跟其原有数值对比取较大值即可，所以递推式如下：
 * 
 * dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);
 * 
 * 有了递推式，我们就可以很容易的写出代码如下：
 * 遞迴關係（英語：Recurrence relation），在數學上也就是差分方程式（Difference equation）
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) { // 每个字符串只能用一次
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            // 因為每一次都跟之前的資料做比較 所以用"递推式" "遞迴關係" "Recurrence relation"
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

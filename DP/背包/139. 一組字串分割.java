package DP.背包;

import java.util.List;

/**
 * 一組字串
 * dp 主要紀錄字元是不是相等
 * stringObject.substring(start,end) 返回两个指定索引之间的字符，包含start，不包含end的元素
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) { // 对物品的迭代应该放在最里层
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len]; // 因為字串只要一邊ok就可以算有了
                }
            }
        }
        return dp[n];
    }
}

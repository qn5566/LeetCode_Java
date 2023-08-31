题目描述

给定一年内旅行的日期列表 days，旅游的天数为 1~365 天，车票有三种类型：

1 日通行证售价为 costs[0] 美元；
7 日通行证售价为 costs[1] 美元；
30 日通行证售价为 costs[2] 美元。
通行证允许在有效期内无限次乘车。例如，如果我们在第 2 天获得了一张 7 日通行证，那么我们可以连着 7 天旅行：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。

返回完成给定旅行计划所需的最小金额。

解法

我们可以使用动态规划来解决这个问题。具体来说，我们定义 $dp(i)$ 
表示从第 $i$ 天开始到一年结束需要的最小花费，$i$ 的取值范围为 $[365,1]$。当 $i$ 代表的日期不在旅游日期内时，显然不需要进行任何消费，即有状态转移方程：
dp(i)=dp(i+1)
当 $i$ 代表的日期在旅游日期内时，我们考虑如何得到状态转移方程：

dp(i)=min{dp(i+j)+costs[k]}
其中 $k$ 表示购买通行证的类型，$j$ 表示这张通行证可以供旅游 $j$ 天使用。

最后我们只需要求出 $dp(1)$ 即可得到答案。


class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
    val n = days.size
    val durations = intArrayOf(1, 7, 30)

    // dp[i] represents the minimum cost to travel up to days[i]
    val dp = IntArray(n)

    for (i in days.indices) {
        // Initialize dp[i] to the cost of a 1-day pass
        dp[i] = dp.getOrElse(i - 1) { 0 } + costs[0]

        // Check if a 7-day pass is cheaper
        var j = i - 1
        while (j >= 0 && days[i] - days[j] < 7) {
            j--
        }
        dp[i] = minOf(dp[i], dp.getOrElse(j, { 0 }) + costs[1])

        // Check if a 30-day pass is cheaper
        j = i - 1
        while (j >= 0 && days[i] - days[j] < 30) {
            j--
        }
        dp[i] = minOf(dp[i], dp.getOrElse(j, { 0 }) + costs[2])
    }

    return dp.last()
}

}

這是一個用 DP 求解的問題，主要步驟如下：

初始化
先宣告一個整數數組 dp，其中 dp[i] 表示旅遊到第 i 天的最小花費。將 dp 數組初始化為 0。

狀態轉移
對於每個旅遊的日期，需要分別考慮以下三種情況：

使用 1 天通行證，只能旅遊當天
使用 7 天通行證，可以旅遊連續七天
使用 30 天通行證，可以旅遊連續 30 天
對於每個日期 i，都需要依次檢查 i 前面的日期 j，以找到能夠覆蓋 i 的最小費用。具體地：

對於 1 天通行證，直接在 dp[i] 上加上 costs[0]。
對於 7 天通行證，找到最後一個日期 j，滿足 days[i]-days[j] < 7，然後在 dp[j] 上加上 costs[1]。
對於 30 天通行證，找到最後一個日期 j，滿足 days[i]-days[j] < 30，然後在 dp[j] 上加上 costs[2]。
返回結果
dp 數組最後一個元素就是旅遊到最後一天的最小花費，返回這個值即可。

這個算法的時間複雜度為 O(N)，其中 N 為 days 數組的長度。
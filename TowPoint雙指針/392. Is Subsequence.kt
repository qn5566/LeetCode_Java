

"392. Is Subsequence" 是一个简单的字符串匹配问题，它要求判断一个字符串 s 是否为另一个字符串 t 的子序列。

下面是使用 Kotlin 解决这个问题的代码：


class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIndex = 0
        var tIndex = 0

        while (sIndex < s.length && tIndex < t.length) {
            if (s[sIndex] == t[tIndex]) {
                sIndex++
            }
            tIndex++
        }

        return sIndex == s.length
    }
}

这段代码的思想是使用两个指针 sIndex 和 tIndex 分别在字符串 s 和 t 中移动。
我们从头开始遍历两个字符串，如果当前字符匹配，则将 sIndex 向前移动，表示已经找到一个匹配的字符。
最终，如果 sIndex 等于 s 的长度，说明 s 是 t 的子序列，返回 true，否则返回 false。

这个算法的时间复杂度是 O(m + n)，其中 m 和 n 分别是字符串 s 和 t 的长度。
算法的关键是通过同时遍历两个字符串来检查字符是否匹配，从而确定 s 是否是 t 的子序列。希望这个解释对你有所帮助。如果你有任何进一步的问题，请随时提问。
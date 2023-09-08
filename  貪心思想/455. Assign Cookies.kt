
"455. Assign Cookies" 是一个贪心算法（Greedy Algorithm）的经典问题。问题的描述如下：

你有一组小孩和一组饼干，每个小孩都有一个贪婪因子（代表他们想要的最小饼干大小），
每个饼干都有一个大小。如果饼干大小大于或等于一个小孩的贪婪因子，那么这个小孩可以得到满足，即分配一块饼干。你的目标是最大化分配的饼干数量。

要解决这个问题，你可以采用贪心策略。具体来说，你可以按照小孩的贪婪因子和饼干的大小对它们进行排序，
然后从小孩列表和饼干列表的开头开始匹配，尽可能多地满足小孩的需求。

以下是使用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort() // 排序小孩的贪婪因子
        s.sort() // 排序饼干的大小
        
        var childIndex = 0 // 小孩索引
        var cookieIndex = 0 // 饼干索引
        var count = 0 // 已分配饼干数量
        
        while (childIndex < g.size && cookieIndex < s.size) {
            if (g[childIndex] <= s[cookieIndex]) {
                // 如果当前饼干能满足当前小孩的贪婪因子
                count++
                childIndex++
            }
            // 不论是否满足，都要尝试下一个饼干
            cookieIndex++
        }
        
        return count
    }
}

这个代码首先对小孩的贪婪因子数组 g 和饼干的大小数组 s 进行排序，以便在贪心策略中按照从小到大的顺序分配饼干。
然后，我们使用两个索引 childIndex 和 cookieIndex 分别表示当前小孩和饼干的位置。
我们开始遍历小孩和饼干列表，如果当前饼干的大小可以满足当前小孩的贪婪因子，就将饼干分配给小孩，并增加 count 计数器。
然后，无论是否满足，都会尝试下一个饼干，直到小孩列表或饼干列表的末尾。

最后，返回 count，它表示分配的最大饼干数量，即满足的小孩数量。

这个算法的时间复杂度是 O(nlogn)，其中 n 是小孩的数量或饼干的数量，
因为我们需要对两个数组进行排序。希望这个解释和示例代码有助于理解 "455. Assign Cookies" 问题的解决方法。
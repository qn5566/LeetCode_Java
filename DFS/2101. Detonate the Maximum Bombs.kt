這個問題可以轉化為一個匹配問題，其中每個炸彈都視為一個節點，而兩個炸彈之間是否會引爆彼此則視為節點之間的邊。

首先，我們使用一個HashMap來建立一個鄰接表，其中鍵為炸彈的索引，值為一個列表，記錄與該炸彈相鄰的其他炸彈的索引。這一步的目的是找出所有能夠引爆彼此的炸彈。

接下來，我們使用一個二維數組dp來記錄已計算過的狀態，初始值設為-1。這是為了避免重複計算。

然後，我們遍歷每個炸彈，對於每個炸彈，我們使用深度優先搜索（DFS）來尋找從當前炸彈到目標炸彈的路徑。如果找到了這樣的路徑，則將dp[current][target]設為1，表示可以通過引爆這些炸彈從當前炸彈到達目標炸彈。如果沒有找到路徑，則將dp[current][target]設為0。

在DFS過程中，我們使用isVisited數組來標記已訪問的炸彈，以避免重複訪問。

最後，我們遍歷每個炸彈，統計能夠通過引爆其他炸彈到達的炸彈數量的最大值，並將其作為結果返回。

這種解法的核心思想是利用DFS在圖中尋找從起始節點到目標節點的路徑。通過使用鄰接表和狀態矩陣來優化計算，可以有效地解決這個問題。

--------------------------------以上是解釋----------------------------------------

以下是解釋每次遞迴中如何處理 isVisited 陣列的流程：

1. 在 dfs 函式開始遞迴之前，我們創建一個新的 isVisited 陣列，長度與 n 相同，並將所有元素初始化為 false。

2. 在遞迴過程中，我們將當前節點 current 標記為已訪問，即 isVisited[current] = true。

3. 然後，我們遞迴地探索當前節點的相鄰節點。在遞迴調用期間，我們使用新的 isVisited 陣列，該陣列是在上一層遞迴的基礎上進行複製的。這保證了每個遞迴過程都有自己的 isVisited 陣列，不會與其他遞迴過程產生衝突。

總結起來，每次遞迴都有一個獨立的 isVisited 陣列，能夠正確地追蹤每個遞迴過程中的節點訪問情況，並確保每個節點只被訪問一次。這樣可以避免無效的遞迴和重複訪問。

class Solution {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val n = bombs.size
        val map = HashMap<Int, MutableList<Int>>()
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) continue
                if (isDetonated(bombs[i], bombs[j])) {
                    map.putIfAbsent(i, mutableListOf())
                    map[i]?.add(j)
                }
            }
        }
        
        val dp = Array(n) { IntArray(n) { -1 } }
        var result = 0
        
        for (i in 0 until n) {
            var max = 0
            
            for (j in 0 until n) {
                if (dfs(map, i, j, BooleanArray(n), dp)) {
                    max++
                }
            }
            
            result = maxOf(max, result)
        }
        
        return result
    }

    private fun dfs(map: Map<Int, List<Int>>, current: Int, target: Int, isVisited: BooleanArray, dp: Array<IntArray>): Boolean {
        if (isVisited[current]) return false
        if (current == target) return true
        if (dp[current][target] >= 0) return dp[current][target] > 0
        
        isVisited[current] = true
        val next = map[current]
        if (next == null) return false
        
        for (e in next) {
            if (dfs(map, e, target, isVisited, dp)) {
                dp[current][target] = 1
                return true
            }
        }
        
        dp[current][target] = 0
        return false
    }

    private fun isDetonated(a: IntArray, b: IntArray): Boolean {
        val r = a[2].toLong()
        val dx = Math.abs(a[0] - b[0]).toLong()
        val dy = Math.abs(a[1] - b[1]).toLong()
        return r * r >= (dx * dx + dy * dy)
    }
}

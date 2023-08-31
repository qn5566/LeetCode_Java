這道題目要求計算無向圖中所有不可達的節點對的數量。假設圖中共有 n 個節點，編號為 0, 1, 2, ..., n-1，
其中邊的數量為 edges。我們可以使用深度優先搜索（DFS）來解決這個問題。
首先，我們需要建立一個鄰接表（adjacency list）來表示圖。對於節點 i，
鄰接表 adj[i] 存儲與節點 i 相鄰的所有節點。因為是無向圖，所以邊是雙向的，
即對於邊 [i, j]，需要將節點 j 加入到 adj[i] 中，同時將節點 i 加入到 adj[j] 中。
接著，我們從節點 0 開始進行 DFS，將所有與節點 0 不可達的節點存儲到一個集合中。對於每個節點 i，
如果它不在集合中，則表示它是可達的，我們可以從它出發進行 DFS，將所有與它不可達的節點存儲到集合中。最後，未被存儲在集合中的節點對就是不可達的節點對，它們的數量即為 (n - unreachable.size) * unreachable.size。

以下是完整的 Kotlin 代碼實現：

class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val graph = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        val seen = BooleanArray(n)
        var cur: Long = 0
        var ans: Long = 0

        fun dfs(u: Int) {
            ++cur
            seen[u] = true
            for (v in graph[u]) {
                if (!seen[v]) {
                    dfs(v)
                }
            }
        }

        for (i in 0 until n) {
            if (seen[i]) {
                continue
            }
            cur = 0
            dfs(i)
            ans += (n - cur) * cur
        }
        return ans / 2
    }
}

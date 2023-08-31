https://www.youtube.com/watch?v=670Gn4e89B8

這個算法用於判斷一個無向圖是否為二分圖。二分圖是一個圖，其中的節點可以分為兩個獨立的集合，且圖中沒有同一集合內的節點之間有邊相連。
該算法使用深度優先搜索（DFS）來遍歷圖中的節點。它創建一個大小為 n 的 visited 數組，其中 n 是圖中節點的數量。
visited 數組用於標記每個節點的狀態，初始值為 0。狀態 0 表示節點尚未訪問過。
算法從第一個節點開始遍歷圖中的每個節點。如果該節點尚未訪問過，則將其標記為狀態 1，表示它屬於集合 A。
然後，遞歸地對與該節點相鄰的節點進行遍歷。在遍歷過程中，如果相鄰節點尚未訪問過，則將其標記為與當前節點不同的狀態（-1 * color），表示它屬於集合 B。如果相鄰節點已經訪問過且與當前節點屬於相同的集合，則圖不是二分圖，返回 false。
最終，如果遍歷結束後所有節點都被訪問且滿足二分圖的條件（即沒有同一集合內的節點相連），則返回 true，否則返回 false。
這個算法的時間複雜度為 O(V + E)，其中 V 是節點的數量，E 是邊的數量。

class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val n = graph.size
        val visited = IntArray(n)
        for (i in 0 until n) {
            if (visited[i] == 0) {
                visited[i] = 1
                if (!dfs(graph, visited, i, 1)) return false
            }
        }
        return true
    }

    private fun dfs(graph: Array<IntArray>, visited: IntArray, cur: Int, color: Int): Boolean {
        var res = true
        for (next in graph[cur]) {
            if (visited[next] == 0) {
                visited[next] = -1 * color
                res = res && dfs(graph, visited, next, -1 * color)
            } else if (visited[next] == color) return false
        }
        return res
    }
}

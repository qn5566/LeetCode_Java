在這個問題中，我們有一個有向無環圖（DAG），其中的節點表示城市，邊表示城市之間的道路。
我們需要找到一組最小的起點節點集合，使得這些起點節點可以到達圖中的所有其他節點。
解決這個問題的一種方法是檢查每個節點，如果一個節點沒有任何入邊（即沒有指向它的邊），
則將其添加到結果集中。這是因為這樣的節點是不可從其他節點到達的起點。
可以使用集合（Set）來存儲結果集，遍歷所有的邊，將邊的終點節點添加到集合中。
然後，遍歷所有的節點，如果節點不在結果集中，則將其添加到結果集中。最終，返回結果集作為最小起點節點的集合。
以下是這個問題的Kotlin代碼示例：


class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val result = mutableSetOf<Int>()
        val incomingEdges = mutableSetOf<Int>()
        
        for (edge in edges) {
            incomingEdges.add(edge[1])
        }
        
        for (i in 0 until n) {
            if (i !in incomingEdges) {
                result.add(i)
            }
        }
        
        return result.toList()
    }
}

這段代碼中的 n 表示節點的總數，edges 是一個由邊的起點節點和終點節點組成的列表，
例如 [[0, 1], [1, 2], [2, 0]] 表示有向邊 0 -> 1, 1 -> 2, 2 -> 0。
這個算法的時間複雜度是 O(E + V)，其中 E 是邊的數量，V 是節點的數量。
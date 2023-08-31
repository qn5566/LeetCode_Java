
import java.util.*

Shortest Path in Binary Matrix問題描述為在一個N x N的二進制矩陣中，
每個格子要麼是0要麼是1，0表示可以通行，1表示不可通行。要求找到從矩陣的左上角到右下角的最短路徑，只能水平、垂直和對角線移動，不能走斜角線。
這個問題可以使用廣度優先搜索（BFS）算法來解決。首先將起點加入隊列，然後遍歷隊列中的節點，
對於每個節點，我們可以向8個方向之一進行移動（水平、垂直和對角線），如果該方向的下一個節點是有效的（即在矩陣範圍內且為0），
我們將其加入隊列中並標記為已訪問。同時，我們需要維護一個距離矩陣，記錄每個節點的最短路徑長度。

當我們遍歷到終點節點時，如果終點節點已訪問過並且距離矩陣中的值不為無窮大，則找到了從起點到終點的最短路徑長度。
如果遍歷完所有的節點仍然沒有找到最短路徑，則返回-1表示無法到達終點。

綜上所述，這個問題的解法是基於廣度優先搜索算法，通過遍歷矩陣中的節點，構建最短路徑的距離矩陣，
並找到從起點到終點的最短路徑長度。

下面是使用BFS算法解決Shortest Path in Binary Matrix問題的Kotlin代碼：

class Solution {
    private val directions = arrayOf(
        intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
        intArrayOf(0, -1), /* current position */ intArrayOf(0, 1),
        intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
    )

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(n) { BooleanArray(n) }
        val distance = Array(n) { IntArray(n) }

        queue.offer(Pair(0, 0))
        visited[0][0] = true
        distance[0][0] = 1

        while (!queue.isEmpty()) {
            val current = queue.poll()
            val x = current.first
            val y = current.second

            if (x == n - 1 && y == n - 1) {
                return distance[x][y]
            }

            for (dir in directions) {
                val newX = x + dir[0]
                val newY = y + dir[1]

                if (isValid(newX, newY, n) && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    queue.offer(Pair(newX, newY))
                    visited[newX][newY] = true
                    distance[newX][newY] = distance[x][y] + 1
                }
            }
        }

        return -1
    }

    private fun isValid(x: Int, y: Int, n: Int): Boolean {
        return x >= 0 && x < n && y >= 0 && y < n
    }
}
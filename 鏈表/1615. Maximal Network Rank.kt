這個問題是要找出在一個城市間的路線網絡中，兩個不同城市的最大網絡排名。
你有一個整數 n 代表城市的數量，還有兩個陣列 roads 和 cities。
這些陣列的長度都是 m，其中每個 roads[i] = [a, b] 代表城市 a 和 b 之間有一條雙向道路，而每個 cities[i] 代表擁有圖書館的城市。
兩個不同城市的網絡排名被定義為直接連接到這兩個城市的道路的總數。
換句話說，它是連接到城市 a 的道路數量與連接到城市 b 的道路數量的總和。
你需要找出所有不同城市對之間的最大網絡排名。
以下是可能的 Kotlin 解法：

class Solution {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        
        // 將 roads 中的道路資訊加入到圖中
        for (road in roads) {
            val (a, b) = road // 解構道路陣列，取出兩端的城市編號
            graph[a].add(b)   // 將城市 b 加入城市 a 的鄰接串列
            graph[b].add(a)   // 將城市 a 加入城市 b 的鄰接串列
        }
        
        var maxRank = 0 // 初始化最大的網路排名
        // 遍歷所有城市對的組合
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                var rank = graph[i].size + graph[j].size // 初始排名是兩個城市的鄰接城市總數
                // 如果這兩個城市之間已經有一條道路，則排名要減 1
                if (graph[i].contains(j) || graph[j].contains(i)) {
                    rank--
                }
                // 更新最大排名
                maxRank = maxOf(maxRank, rank)
            }
        }
        
        return maxRank // 回傳最大的網路排名
    }
}

心得

graph 是一個用來表示城市之間道路關係的列表，它是一個長度為 n 的陣列，每個元素都是一個可變長度的整數列表，表示和該城市相鄰的其他城市。

在這個問題中，如果城市 a 和城市 b 之間有道路相連，則 graph[a] 中會添加 b，同時 graph[b] 中也會添加 a，因為道路是雙向的。

例如，如果 roads 為 [[0, 1], [1, 2], [2, 3]]，這表示城市 0 和城市 1 相連，城市 1 和城市 2 相連，城市 2 和城市 3 相連。那麼 graph 可以表示為：

graph[0] = [1]
graph[1] = [0, 2]
graph[2] = [1, 3]
graph[3] = [2]
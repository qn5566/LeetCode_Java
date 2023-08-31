這題的目標是給你一個二維陣列 grid，每個位置存放一個數字，代表從該位置到終點的最小路徑和，
求從左上角到右下角的最小路徑和。
你只能向右或向下移動，不能向上或向左移動。同時，當你從某個位置 (i, j) 移動到 (i+1, j) 
或 (i, j+1) 時，你需要將路徑和加上該位置的值 grid[i][j]。



class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    
    // 初始化第一行
    for (j in 1 until n) {
        grid[0][j] += grid[0][j - 1]
    }
    
    // 初始化第一列
    for (i in 1 until m) {
        grid[i][0] += grid[i - 1][0]
    }
    
    // DP，计算到达每个点的最小路径和
    for (i in 1 until m) {
        for (j in 1 until n) {
            grid[i][j] += minOf(grid[i - 1][j], grid[i][j - 1])
        }
    }
    
    return grid[m - 1][n - 1]
}

}

这里使用了动态规划（DP）的思想，从左上角开始递推计算到达每个点的最小路径和。
具体做法是，先初始化第一行和第一列的值，然后从第二行和第二列开始，
每个点的最小路径和可以通过它上方和左方的点的最小路径和加上当前点的值得到，
然后取这两个值的较小值即可。最终右下角的值就是从左上角到右下角的最小路径和。
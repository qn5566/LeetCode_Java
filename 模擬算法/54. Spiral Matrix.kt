
這個算法通過維護四個變數來跟踪當前還沒有遍歷的邊界，然後按照右、下、左、上的順序遍歷邊界，每次遍歷一個邊界後，相應的邊界縮小一格。遍歷過程中，將每個訪問過的元素添加到結果列表中。
在遍歷過程中，需要特判只有一行或一列的情況。另外，當縮小邊界的變數越過對方變數時，需要退出循環，否則會出現重複訪問的情況。

因為 top 和 bottom 表示的是下標，而不是元素個數，而在這個迴圈中，我們要從 top 下一行開始遍歷到 bottom 行，
因此需要將 top 加 1。舉例來說，如果 top 的初始值為 0，則 top + 1 為 1，即我們要從第二行開始遍歷。

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        var left = 0
        var right = matrix[0].size - 1
        var top = 0
        var bottom = matrix.size - 1
        
        while (left <= right && top <= bottom) {
            // Traverse right
            for (col in left..right) {
                result.add(matrix[top][col])
            }
            
            // Traverse down
            for (row in top + 1..bottom) {
                result.add(matrix[row][right])
            }
            
            // Traverse left
            if (top < bottom) {
                for (col in right - 1 downTo left) {
                    result.add(matrix[bottom][col])
                }
            }
            
            // Traverse up
            if (left < right) {
                for (row in bottom - 1 downTo top + 1) {
                    result.add(matrix[row][left])
                }
            }
            
            left++
            right--
            top++
            bottom--
        }
        
        return result
    }
}

這個問題的目標是找出在二維矩陣 grid 中，有多少對「行（Row）」和「列（Column）」的組合，
其中相對應的行和列是相等的。

在這個解法中，我們使用兩個嵌套的迴圈 i 和 j，用來遍歷所有的行和列。
對於每一組行 i 和列 j 的組合，我們檢查對應的元素是否相等。


class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val rowCount = grid.size
        val columnCount = grid[0].size
        val columnList: MutableList<MutableList<Int>> = mutableListOf()

        for (columnIndex in 0 until columnCount) {
            val column: MutableList<Int> = mutableListOf()
            for (rowIndex in 0 until rowCount) {
                column.add(grid[rowIndex][columnIndex])
            }
            columnList.add(column)
        }

        var counter = 0
        for (rowIndex in 0 until rowCount) {
            for (columnIndex in 0 until columnCount) {
                if (grid[rowIndex].contentEquals(columnList[columnIndex].toIntArray())) {
                    counter++
                }
            }
        }

        return counter
    }
}



"118. Pascal's Triangle" 问题可以归类为数学和数组操作的问题。
具体来说，它涉及到生成和操作帕斯卡三角形，这是一个由整数组成的特殊数学结构。
解决这个问题需要一定的数学思维，同时也需要使用数组数据结构来表示和存储帕斯卡三角形的每一行。
因此，这个问题可以被归类为数学和数组操作的问题。

"Pascal's Triangle"（帕斯卡三角形）是一个经典的数学问题，它要求生成帕斯卡三角形的前n行。
帕斯卡三角形是一个由整数组成的三角形，其中第一行是数字1，接下来的每一行都是从前一行计算而来的。



class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (numRows <= 0) return result
        
        // 第一行始终是[1]
        result.add(listOf(1))
        
        for (i in 1 until numRows) {
            val prevRow = result[i - 1]
            val currentRow = mutableListOf<Int>()
            
            // 每一行的第一个元素始终是1
            currentRow.add(1)
            
            // 计算中间的元素
            for (j in 1 until i) {
                val sum = prevRow[j - 1] + prevRow[j]
                currentRow.add(sum)
            }
            
            // 每一行的最后一个元素始终是1
            currentRow.add(1)
            
            result.add(currentRow)
        }
        
        return result
    }
}

这个代码通过迭代生成帕斯卡三角形的每一行，从第一行开始，逐行计算。
在每一行中，我们首先在新行的开头添加一个1，然后计算中间的元素，每个中间元素都等于前一行对应位置和前一行对应位置的前一个元素之和。
最后，我们在新行的末尾再添加一个1。
这个算法的时间复杂度是 O(numRows^2)，因为我们需要计算每一行的元素。
希望这个解释和示例代码有助于理解 "118. Pascal's Triangle" 问题的解决方法。





class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size
    var left = 0
    var right = m * n - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        val midValue = matrix[mid / n][mid % n]

        when {
            midValue < target -> left = mid + 1
            midValue > target -> right = mid - 1
            else -> return true
        }
    }

    return false
    }
}

這個問題要找出山脈陣列中的峰值索引。山脈陣列是指一個陣列，其中有一個索引 i，滿足：

arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
換句話說，山脈陣列是先上升後下降的一個陣列。我們的目標是找到這個峰值索引 i。

以下是一種解決方案，使用二元搜索 (Binary Search) 的方法來找到峰值索引：

這個解決方案的時間複雜度是 O(log n)，其中 n 是陣列的長度。透過不斷縮小搜索範圍，
我們可以高效地找到峰值索引。請嘗試將你的山脈陣列帶入這個函數中看看是否能夠正確地找到峰值索引。

class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = 0
        var right = arr.size - 1
        
        while (left < right) {
            val mid = left + (right - left) / 2
            
            if (arr[mid] < arr[mid + 1]) {
                // 中間值小於後面一個值，則峰值在右半部分
                left = mid + 1
            } else {
                // 中間值大於等於後面一個值，則峰值在左半部分或中間值本身就是峰值
                right = mid
            }
        }   
        return left // 或者 right，因為最終 left 和 right 相等
    }    
}
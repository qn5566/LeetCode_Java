
"34. Find First and Last Position of Element in Sorted Array" 
是一个在有序数组中查找元素的问题，要求返回目标元素第一次和最后一次出现的位置。

这个代码使用了经典的二分查找算法来查找目标元素的第一次出现位置和最后一次出现位置。
首先，我们定义一个结果数组 result，并初始化为两个 -1，表示如果找不到目标元素，则返回 -1。

然后，我们分别调用 findFirstPosition 和 findLastPosition 函数来查找第一次和最后一次出现的位置。
这两个函数使用了二分查找的思想，分别在左半部分和右半部分查找目标元素的位置。

最后，我们将两个位置结果放入 result 数组中并返回。

这个算法的时间复杂度是 O(log n)，其中 n 是数组的长度。希望这个解释和示例代码有助于理解
 "34. Find First and Last Position of Element in Sorted Array" 问题的解决方法。

以下是使用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2) { -1 } // 初始化结果数组，如果找不到目标元素，两个位置都为 -1
        result[0] = findFirstPosition(nums, target) // 查找第一次出现的位置
        result[1] = findLastPosition(nums, target) // 查找最后一次出现的位置
        return result
    }
    
    private fun findFirstPosition(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var firstPosition = -1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] == target) {
                firstPosition = mid // 找到目标元素
                right = mid - 1 // 继续向左查找第一次出现的位置
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return firstPosition
    }
    
    private fun findLastPosition(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var lastPosition = -1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] == target) {
                lastPosition = mid // 找到目标元素
                left = mid + 1 // 继续向右查找最后一次出现的位置
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return lastPosition
    }
}



"153. Find Minimum in Rotated Sorted Array" 是一个在旋转排序数组中查找最小元素的问题。
这个问题涉及一个已排序的数组，在某个未知的位置进行了旋转，你需要找到数组中的最小元素。

以下是使用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0 // 左边界
        var right = nums.size - 1 // 右边界
        
        while (left < right) {
            val mid = left + (right - left) / 2 // 计算中间索引
            
            if (nums[mid] > nums[right]) {
                // 如果中间元素大于右边界元素，说明最小元素在右半部分
                left = mid + 1
            } else {
                // 否则，最小元素在左半部分或者就是中间元素
                right = mid
            }
        }
        
        return nums[left] // 返回左边界元素，即最小元素
    }
}


这个代码使用了二分查找算法来寻找旋转排序数组中的最小元素。
首先，我们初始化左边界 left 为0和右边界 right 为数组的最后一个索引。

在循环中，我们计算中间索引 mid，并比较 nums[mid] 与 nums[right]。
如果中间元素大于右边界元素，说明最小元素在右半部分，因此我们更新左边界 left 为 mid + 1。
否则，最小元素可能在左半部分或者就是中间元素，所以我们更新右边界 right 为 mid。

最终，循环结束后，返回左边界元素 nums[left]，它是最小元素。

这个算法的时间复杂度是 O(log n)，其中 n 是数组的长度，因为二分查找将搜索范围每次减少一半。
希望这个解释和示例代码有助于理解 "153. Find Minimum in Rotated Sorted Array" 问题的解决方法。
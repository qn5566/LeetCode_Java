

"704. Binary Search" 是一个经典的二分查找问题。问题描述如下：

给定一个排序的整数数组 nums，和一个目标值 target，如果目标值在数组中存在，则返回目标值的索引；
如果目标值不存在于数组中，则返回 -1。

要解决这个问题，可以使用二分查找算法来快速搜索目标值。
以下是使用 Kotlin 解决这个问题的示例代码：
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0 // 左边界
        var right = nums.size - 1 // 右边界
        
        while (left <= right) {
            val mid = left + (right - left) / 2 // 计算中间索引
            
            if (nums[mid] == target) {
                return mid // 找到目标值，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1 // 目标值在右半部分
            } else {
                right = mid - 1 // 目标值在左半部分
            }
        }
        
        return -1 // 如果循环结束仍然没有找到目标值，返回 -1
    }
}

在这个代码中，我们初始化两个指针 left 和 right，分别指向数组的第一个元素和最后一个元素。

在循环中，我们计算中间索引 mid，这是通过 left + (right - left) / 2 计算得到的，确保 mid 是两个相邻元素的中间位置。

然后，我们比较 nums[mid] 与目标值 target：

1. 如果相等，表示找到了目标值，直接返回 mid。
2. 如果 nums[mid] 小于 target，说明目标值在右半部分，更新 left 为 mid + 1。
3. 如果 nums[mid] 大于 target，说明目标值在左半部分，更新 right 为 mid - 1。

循环继续，直到 left 大于 right，表示没有找到目标值，返回 -1。

这个算法的时间复杂度是 O(log n)，其中 n 是数组的长度。
希望这个解释和示例代码有助于理解 "704. Binary Search" 问题的解决方法。
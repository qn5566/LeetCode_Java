

解决这个问题的关键在于使用双指针法。
开始时，我们将左指针指向数组的开头，将右指针指向数组的末尾，表示当前容器的边界。
然后，我们计算当前容器的面积，并将其与已知的最大面积进行比较。

接着，我们将较短的线段向内移动一个位置，这是因为如果移动较长的线段，容器的宽度会减小，
因此容纳的水量不会增加。而移动较短的线段可能会找到更高的线段，从而有可能增加容器的高度。

我们一直重复这个过程，直到左指针大于等于右指针，表示无法再找到更高的线段，计算过程结束。

这个算法的时间复杂度是 O(n)，其中 n 是输入数组的长度。
希望这个解释和示例代码有助于理解 "11. Container With Most Water" 问题的解决方法。

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0 // 左边界指针
        var right = height.size - 1 // 右边界指针
        var maxArea = 0 // 最大容器面积
        
        while (left < right) {
            val hLeft = height[left]
            val hRight = height[right]
            val h = minOf(hLeft, hRight) // 选取较短的高度
            val w = right - left // 宽度
            
            val area = h * w // 计算当前容器的面积
            maxArea = maxOf(maxArea, area) // 更新最大面积
            
            // 移动较短的指针，以期望找到更高的线段
            if (hLeft < hRight) {
                left++
            } else {
                right--
            }
        }
        return maxArea
    }
}

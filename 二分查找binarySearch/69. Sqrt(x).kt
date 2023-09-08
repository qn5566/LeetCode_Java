

"69. Sqrt(x)" 是一个求平方根的问题。问题描述如下：

给定一个非负整数 x，计算并返回它的平方根，精确到小数点后面的整数部分。
也就是说，你需要返回一个整数，它是 x 的平方根的整数部分。
要解决这个问题，有几种方法可以考虑，其中一种方法是使用二分查找。
以下是使用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun mySqrt(x: Int): Int {
        if (x <= 1) return x // 如果 x 小于等于 1，直接返回 x
        
        var left = 1 // 左边界
        var right = x // 右边界
        
        while (left <= right) {
            val mid = left + (right - left) / 2 // 计算中间值
            
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                // 如果 mid 是平方根，返回 mid
                return mid
            } else if (mid > x / mid) {
                // 如果 mid 的平方大于 x，说明平方根在左边
                right = mid - 1
            } else {
                // 否则，平方根在右边
                left = mid + 1
            }
        }
        
        return left // 返回左边界，也就是平方根的整数部分
    }
}

这个代码使用二分查找算法来寻找 x 的平方根。
首先，我们处理一些特殊情况，如果 x 小于等于1，那么它的平方根就是它自己，直接返回 x。

然后，我们初始化左边界 left 为1和右边界 right 为 x，因为平方根不可能大于 x。
在循环中，我们计算中间值 mid，并比较 mid 与 x / mid 以确定平方根的位置。
如果 mid 是平方根，我们返回 mid。
否则，如果 mid 的平方大于 x，说明平方根在左边，更新右边界 right 为 mid - 1。
如果 mid 的平方小于 x，说明平方根在右边，更新左边界 left 为 mid + 1。

最后，循环结束后，返回左边界 left，它是平方根的整数部分。

这个算法的时间复杂度是 O(log x)，因为二分查找将搜索范围每次减少一半。
希望这个解释和示例代码有助于理解 "69. Sqrt(x)" 问题的解决方法。

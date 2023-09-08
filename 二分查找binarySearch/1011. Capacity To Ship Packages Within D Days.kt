
问题描述：

给定一个整数数组 weights，其中 weights[i] 是第 i 个包裹的重量，以及一个整数 D，表示运送 D 天。
你可以运送包裹的最大重量是多少，以使得在 D 天内将所有包裹都运送完毕？

要解决这个问题，你可以使用二分查找来找到最小的运送容量。
以下是使用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        var left = weights.maxOrNull() ?: 0 // 左边界，最小的运送容量是最重的包裹的重量
        var right = weights.sum() // 右边界，最大的运送容量是所有包裹的重量之和
        
        while (left < right) {
            val mid = left + (right - left) / 2 // 计算中间容量
            
            if (canShip(weights, D, mid)) {
                right = mid // 可以在 D 天内运送完，缩小右边界
            } else {
                left = mid + 1 // 需要更多天才能运送完，增大左边界
            }
        }
        
        return left // 最终左边界的值就是最小的运送容量
    }
    
    private fun canShip(weights: IntArray, D: Int, capacity: Int): Boolean {
        var days = 1 // 当前运送天数
        var currentCapacity = 0 // 当前承载重量
        
        for (weight in weights) {
            if (currentCapacity + weight <= capacity) {
                currentCapacity += weight
            } else {
                days++ // 开启新一天
                currentCapacity = weight
            }
            
            if (days > D) {
                return false // 需要的天数超过了 D
            }
        }
        
        return true // 在 D 天内运送完
    }
}

在这个代码中，我们首先初始化左边界 left 和右边界 right。
左边界 left 初始化为最重的包裹的重量，右边界 right 初始化为所有包裹的重量之和。

然后，我们进入二分查找循环，循环条件是 left < right，即左边界小于右边界。

在循环中，我们计算中间容量 mid，然后调用 canShip 函数来判断是否可以在 D 天内运送完。
如果可以，说明当前容量可能过大，我们缩小右边界 right；如果不行，说明当前容量过小，我们增大左边界 left。

canShip 函数用于判断在给定容量下是否可以在 D 天内运送完所有包裹。
它遍历包裹的重量，尝试将每个包裹放入当前运送容量中，如果放不下，则开启新的一天，并将当前容量重新设置为该包裹的重量。
如果需要的天数超过 D，则返回 false，否则返回 true。

最终，循环结束后，left 的值就是最小的运送容量，我们将其作为结果返回。

这个算法的时间复杂度是 O(n * log(sum(weights)))，其中 n 是包裹的数量，sum(weights) 是所有包裹的重量之和。
希望这个解释和示例代码有助于理解 "1011. Capacity To Ship Packages Within D Days" 问题的解决方法。





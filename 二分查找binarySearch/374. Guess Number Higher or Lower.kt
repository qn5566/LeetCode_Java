


"374. Guess Number Higher or Lower" 是一个猜数字游戏的问题。问题描述如下：

猜数字游戏的规则如下：

1. 我们在 1 到 n 之间选择一个数字，你需要猜出这个数字是多少。
2. 每次你猜测一个数字，我们会告诉你这个数字是正确的、太低了还是太高了。
3. 你调用 guess(int num) 函数，它会返回三种可能的结果之一：
    -1：表示你猜测的数字太低。
    1：表示你猜测的数字太高。
    0：表示恭喜，你猜对了。
要解决这个问题，可以使用二分查找算法来快速找到目标数字。
以下是使用 Kotlin 解决这个问题的示例代码：

class Solution : GuessGame() {
    override fun guessNumber(n:Int):Int {
        var left = 1 // 左边界
        var right = n // 右边界
        
        while (left <= right) {
            val mid = left + (right - left) / 2 // 计算中间值
            
            val result = guess(mid) // 调用 guess 函数得到结果
            
            if (result == 0) {
                return mid // 猜对了，返回中间值
            } else if (result == -1) {
                right = mid - 1 // 目标数字在左半部分
            } else {
                left = mid + 1 // 目标数字在右半部分
            }
        }
        
        return -1 // 如果循环结束仍然没有猜对，返回 -1
    }
}

在这个代码中，我们使用二分查找算法来快速猜测目标数字。
首先，我们初始化左边界 left 为1和右边界 right 为 n。

在循环中，我们计算中间值 mid，然后调用 guess(mid) 函数来获得结果。根据结果，我们可以采取以下行动：

如果结果为0，表示猜对了，直接返回中间值 mid。
如果结果为-1，表示猜测的数字太低，更新右边界 right。
如果结果为1，表示猜测的数字太高，更新左边界 left。
循环继续，直到 left 大于 right，表示没有找到目标数字，返回 -1。

这个算法的时间复杂度是 O(log n)，其中 n 是数字范围。
希望这个解释和示例代码有助于理解 "374. Guess Number Higher or Lower" 问题的解决方法。
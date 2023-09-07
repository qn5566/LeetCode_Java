给定一个包含非负整数和运算符的字符串，你需要为表达式添加括号，
以改变表达式的运算顺序，以获得不同的计算结果。返回所有可能的计算结果。

这个问题可以使用递归和分治法来解决。具体思路如下：

1. 遍历输入字符串，找到运算符。每次遇到运算符时，将字符串分成两部分，左部分和右部分。例如，对于表达式 "2-1-1"，遇到第一个减号时，可以将其分成 "2" 和 "1-1" 两部分。
2. 对左部分和右部分分别递归调用函数，以获得它们的计算结果集合。
3. 将左部分的计算结果与右部分的计算结果按照当前运算符进行组合，得到当前表达式的所有可能结果。
4. 递归终止条件是字符串中没有运算符，即只剩下一个数字。
以下是使用 Kotlin 实现的示例代码：

class Solution {
    fun diffWaysToCompute(input: String): List<Int> {
        val result = mutableListOf<Int>()
        for (i in 0 until input.length) {
            val c = input[i]
            if (c == '+' || c == '-' || c == '*') {
                val leftPart = input.substring(0, i)
                val rightPart = input.substring(i + 1)
                val leftResults = diffWaysToCompute(leftPart)
                val rightResults = diffWaysToCompute(rightPart)
                for (left in leftResults) {
                    for (right in rightResults) {
                        when (c) {
                            '+' -> result.add(left + right)
                            '-' -> result.add(left - right)
                            '*' -> result.add(left * right)
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            // 如果没有运算符，说明是单一数字，直接将其转换成整数
            result.add(input.toInt())
        }
        return result
    }
}
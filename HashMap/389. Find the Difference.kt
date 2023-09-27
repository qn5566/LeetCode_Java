"389. Find the Difference" 是一个字符串操作问题。给定两个字符串 s 和 t，
其中 t 是 s 的一个变异，通过在 s 中添加一个额外的字母并重新排列字母的方式得到的。要找到添加的字母是什么。

以下是用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val charCount = HashMap<Char, Int>()

        // 计算字符串 s 中每个字符的出现次数
        for (char in s) {
            charCount[char] = charCount.getOrDefault(char, 0) + 1
        }

        // 遍历字符串 t，并检查每个字符是否在 s 中出现过
        for (char in t) {
            if (!charCount.containsKey(char) || charCount[char] == 0) {
                return char
            }
            charCount[char] = charCount[char]!! - 1
        }

        return ' ' // 此行不会执行，因为 t 是 s 的变异，一定会找到额外的字符
    }
}

这段代码的核心思想是使用哈希表来记录字符串 s 中每个字符的出现次数，然后遍历字符串 t，
检查每个字符是否在 s 中出现过。如果在 s 中没有找到该字符或者该字符的出现次数已经为零，则说明它是额外添加的字符，即答案。

这个算法的时间复杂度是 O(n)，其中 n 是字符串 t 的长度。希望这个解释对你有所帮助。如果你有任何进一步的问题，请随时提问。
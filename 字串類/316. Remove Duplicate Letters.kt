
"316. Remove Duplicate Letters" 是一个字符串处理问题。给定一个只包含小写字母的字符串，
你需要移除字符串中的重复字母，使得每个字母在最终结果中只出现一次，并且结果字符串的字典序最小。

以下是用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun removeDuplicateLetters(s: String): String {
        val lastOccurrence = IntArray(26)
        val inStack = BooleanArray(26)
        val stack = mutableListOf<Char>()

        // 记录每个字符最后一次出现的位置
        for (i in s.indices) {
            lastOccurrence[s[i] - 'a'] = i
        }

        for (i in s.indices) {
            val c = s[i]

            // 如果字符已经在栈中，跳过
            if (inStack[c - 'a']) continue

            // 检查栈中的字符是否比当前字符大且在后面还会出现
            while (stack.isNotEmpty() && c < stack.last() && i < lastOccurrence[stack.last() - 'a']) {
                val removedChar = stack.removeAt(stack.size - 1)
                inStack[removedChar - 'a'] = false
            }

            // 将当前字符加入栈中
            stack.add(c)
            inStack[c - 'a'] = true
        }

        return stack.joinToString("")
    }
}


这段代码的核心思想是使用一个栈来维护最终结果，同时使用两个额外的数组 lastOccurrence 和 inStack 来辅助处理。具体步骤如下：

1. 遍历字符串 s，记录每个字符最后一次出现的位置，并初始化 inStack 数组为 false。

2. 再次遍历字符串 s，对于每个字符 c：如果字符 c 已经在栈中，跳过。
    检查栈中的字符是否比当前字符 c 大且在后面还会出现，如果是，则将栈顶的字符出栈。
    将当前字符 c 加入栈中，并将对应的 inStack 数组位置设为 true。
3. 最后，将栈中的字符按顺序拼接起来，就得到了结果字符串。

这个算法的时间复杂度是 O(n)，其中 n 是字符串 s 的长度。希望这个解释对你有所帮助。如果你有任何进一步的问题，请随时提问。


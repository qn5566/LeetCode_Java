"重新组织字符串"通常是指一个编程问题，其中你会得到一个包含小写字母的字符串，并被要求重新排列字母，使得任意两个相邻的字母都不相同。这是算法和编程面试中常见的问题。

以下是解决这个问题的一般思路：

计算频率： 首先，计算给定字符串中每个字符的频率。你可以使用哈希映射（hash map）或数组来存储这些频率。

排序字符： 根据它们的频率对字符进行排序。你可以创建一个自定义的排序顺序，将频率较高的字符排在前面。

构建结果字符串： 开始构建结果字符串，通过按排序后的顺序追加字符。确保首先插入最频繁的字符，并在不同的字符之间交替，以避免出现相邻的重复字符。


class Solution {
    fun reorganizeString(s: String): String {
        // 创建一个哈希映射来存储字符的频率
        val charsCount = HashMap<Char, Int>()
        // 记录出现最高频率的字符次数
        var maxCount = 0
        
        // 遍历输入字符串，统计字符频率
        for (i in 0 until s.length) {
            charsCount[s[i]] = (charsCount[s[i]] ?: 0) + 1
            // 更新最高频率
            if (charsCount[s[i]]!! > maxCount) {
                maxCount = charsCount[s[i]]!!
            }
        }

        // 如果最高频率小于等于1，直接返回原字符串，因为无法重新组织
        if (maxCount <= 1) {
            return s
        }
        
        // 如果出现最高频率的字符次数减1，大于剩余字符的数量，无法重新组织，返回空字符串
        if (maxCount - 1 > s.length - maxCount) {
            return ""
        }

        // 使用优先队列（最大堆）根据字符频率进行排序
        val maxHeap = PriorityQueue<Pair<Char, Int>>(Comparator { pairOne, pairTwo ->
            pairTwo.second - pairOne.second
        })
        
        // 将字符频率加入优先队列
        charsCount.entries.forEach { entry ->
            maxHeap.add(entry.key to entry.value)
        }

        // 创建一个字符串构建器来构建重新组织后的字符串
        val result = StringBuilder()
        
        // 从优先队列中选择频率最高的两个字符放置在结果字符串中
        while (maxHeap.size > 1) {
            val maxCount1 = maxHeap.poll()
            val maxCount2 = maxHeap.poll()
            result.append("${maxCount1.first}${maxCount2.first}")
            
            // 如果频率不为1，减少频率后重新加入优先队列
            if (maxCount1.second != 1) {
                maxHeap.add(maxCount1.first to maxCount1.second - 1)
            }
            if (maxCount2.second != 1) {
                maxHeap.add(maxCount2.first to maxCount2.second - 1)
            }
        }

        // 处理剩余一个字符的情况
        if (maxHeap.isNotEmpty()) {
            result.append(maxHeap.poll().first)
        }
        
        // 返回构建好的结果字符串
        return result.toString()
    }
}

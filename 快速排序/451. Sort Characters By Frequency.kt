
import java.util.*

要按字符出现频率对字符进行排序，你可以使用 Kotlin 来实现以下代码：

fun frequencySort(s: String): String {
    // 创建一个哈希表来存储字符和它们的出现频率
    val charCount = mutableMapOf<Char, Int>()

    // 统计字符出现的频率
    for (char in s) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }

    // 创建一个最大堆，根据字符的频率进行排序
    val maxHeap = PriorityQueue<Char> { a, b ->
        charCount[b]!! - charCount[a]!!
    }

    // 将字符添加到最大堆中
    maxHeap.addAll(charCount.keys)

    // 构建结果字符串
    val result = StringBuilder()
    while (maxHeap.isNotEmpty()) {
        val char = maxHeap.poll()
        val frequency = charCount[char]!!

        for (i in 0 until frequency) {
            result.append(char)
        }
    }

    return result.toString()
}

这段代码首先使用哈希表 charCount 统计了每个字符的出现频率。
然后，它创建了一个最大堆 maxHeap，根据字符的频率进行排序。最后，它从最大堆中逐个弹出字符，并根据它们的频率构建结果字符串。

你可以调用 frequencySort(s) 函数，其中 s 是要排序的字符串，它将返回按字符频率排序后的字符串。

这个解决方案的时间复杂度为 O(N log K)，其中 N 是字符串的长度，K 是不同字符的数量。
由于最大堆的大小受字符数量的限制，通常情况下 K 远小于 N，因此该算法是高效的。




/**
 * 題目描述：

給定一個文本字符串 text 和一個目標字符串 pattern，請寫一個函數 strStr(text: String, pattern: String): Int，
返回目標字符串在文本字符串中第一次出現的索引位置，如果目標字符串沒有在文本字符串中出現，則返回 -1。

解法：

可以使用兩個指針分別指向文本字符串和目標字符串，然後遍歷文本字符串，將目標字符串與文本字符串逐個字符進行比較，
如果相同，則將兩個指針都往後移動一位，繼續比較，直到目標字符串遍歷完畢，如果期間沒有出現不同的字符，則表示目標字符串在文本字符串中出現，返回目標字符串在文本字符串中第一次出現的索引位置，否則返回 -1。

 */
class Solution {
    fun strStr(text: String, pattern: String): Int {
    if (pattern.isEmpty()) return 0
    for (i in 0..text.length - pattern.length) {
        var j = 0
        while (j < pattern.length && text[i + j] == pattern[j]) {
            j++
        }
        if (j == pattern.length) return i
    }
    return -1
}
}

/*
在上述代碼中，首先判斷目標字符串是否為空，如果是，則直接返回 0。然後使用一個 for 循環遍歷文本字符串，從第一個字符開始，一直到倒數第二個字符。
在循環過程中，使用一個 while 循環遍歷目標字符串，從第一個字符開始，一直到最後一個字符，同時比較目標字符串和文本字符串中對應位置的字符是否相同，
如果相同，則將兩個指針都往後移動一位，繼續比較，否則退出循環。如果目標字符串遍歷完畢，則表示目標字符串在文本字符串中出現，
返回目標字符串在文本字符串中第一次出現的索引位置。如果在循環過程中已經超出了文本字符串的範圍，則表示目標字符串在文本字符串中不存在，返回 -1。
 */
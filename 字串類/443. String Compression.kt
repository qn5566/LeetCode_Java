


/**
 * 題目描述
給你一個字符陣列 chars，將其壓縮，壓縮規則如下：
從左到右讀取 chars，當遇到一個字符不同於前一個字符時，就計算出前一個相同字符的個數，並將數字與字符結合，形成壓縮後的子陣列。
壓縮後的字符陣列需要保持原始順序。
你必須在壓縮後的字符陣列中替換 chars。
如果壓縮後的字符陣列長度比原始字符陣列 chars 長，則返回原始字符陣列 chars。
你可以假設字符陣列 chars 的長度在 $1$ 到 $1000$ 之間。
範例

Example 1:
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

Example 2:
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: Nothing is replaced.

Example 3:
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The first "b" is replaced by "b1". The next 10 "b"s are replaced by "b12".
Notice that the number "12" consists of two digits, and each of the digits is individual.

解法

此題的解法不難想，只需要用兩個指針來遍歷字符陣列 chars 即可。
一個指針 i 用於遍歷原陣列，另一個指針 j 用於更新壓縮後的陣列。初始化時，i 和 j 都為 $0$。
當 chars[i] 與 chars[i - 1] 不相等時，說明已經到達了與前一個相同字符不同的位置，此時我們就可以計算出前一個相同字符的個數了。
計算完後，將數字轉換成字符，並把轉換後的字符存放在 chars[j] 的位置，然後將 j 加 $1$，接著再把當前的字符存放在 chars[j] 的位置，最後再把 j 加 $1$。
最後，只需要返回 j 的值即可。

解釋：

首先處理邊界情況，如果輸入的字符陣列為空，直接返回 0。
接下來使用兩個指針 i 和 index，其中 i 指向當前要處理的字符，index 指向要更新的位置。對於每個字符，用一個變量 count 計算出現次數。然後，將這個字符更新到位置 index，index++。
如果計算出現次數 count 大於 1，那麼需要將這個數字轉換為字符串，逐位更新到字符陣列中。最後，更新 i 繼續處理下一個字符。
最後返回 index，表示壓縮後字符陣列的長度。

P.S.
這是一種字符串操作算法，主要思路是遍歷字符串中的每個字符，統計其出現次數，然後更新原字符串，達到壓縮字符串的效果。
這種算法主要用於壓縮和解壓縮字符串，並且只能壓縮具有一定規律性的字符串，例如本題中的壓縮方式就是相鄰相同字符的出現次數。
這種算法的時間複雜度為 $O(n)$，其中 $n$ 是字符串的長度。
 */


class Solution {
    fun compress(chars: CharArray): Int {
        if (chars.isEmpty()) return 0
        var index = 0
        var i = 0
        while (i < chars.size) {
            val char = chars[i]
            var count = 1
            while (i < chars.size - 1 && chars[i + 1] == char) {
                count++
                i++
            }
            chars[index] = char
            index++
            if (count > 1) {
                val countStr = count.toString()
                for (j in countStr.indices) {
                    chars[index] = countStr[j]
                    index++
                }
            }
            i++
        }
        return index
    }
}
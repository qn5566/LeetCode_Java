
/**
 * 該算法使用滑動窗口的思想。首先，計算初始長度為 k 的子字符串中元音字母的數量。然後，使用一個循環遍歷從 k 開始到 s 字符串的長度。在每次循環中，
 * 更新計數值 count，並將當前子字符串中的元音字母數量與最大值 maxCount 比較並更新。同時，移動窗口的開始位置，即刪除最前面的字符的計數。
 * 該算法的時間複雜度為 O(n)，其中 n 是 s 字符串的長度。在遍歷 s 字符串時，每個字符只會被處理一次。因此，算法的時間複雜度與輸入字符串的長度成線性關係。
 */


class Solution {
    fun maxVowels(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var maxCount = 0
        var count = 0

        for (i in 0 until k) {
            if (s[i] in vowels) {
                count++
            }
        }

        maxCount = count

        for (i in k until s.length) {
            if (s[i] in vowels) {
                count++
            }
            if (s[i - k] in vowels) {
                count--
            }
            maxCount = maxOf(maxCount, count)
        }

        return maxCount
    }
}



在這個解法中，我們使用了雙指針的方法來遍歷數組 nums。指針 i 指向當前範圍的起始位置，
我們使用內部循環來找到連續遞增的範圍。當遇到不連續的元素時，
我們將當前範圍的起始位置和結束位置加入結果列表 result 中。
如果起始位置和結束位置相同，說明當前範圍只有一個元素，
我們將其轉換為字符串形式並加入 result 中。

如果起始位置和結束位置不相同，說明當前範圍有多個連續遞增的元素，我們將其轉換為字符串形式，並使用箭頭符號 -> 連接起始元素和結束元素，然後將該字符串加入 result 中。

最後返回結果列表 result 即可。

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()

    var i = 0
    while (i < nums.size) {
        val start = i
        while (i + 1 < nums.size && nums[i + 1] == nums[i] + 1) {
            i++
        }
        val end = i
        if (start == end) {
            result.add(nums[start].toString())
        } else {
            result.add("${nums[start]}->${nums[end]}")
        }
        i++
    }

    return result
    }
}
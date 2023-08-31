在這個解法中，我們使用了兩個指針 i 和 j。
指針 i 遍歷整個數組，當遇到一個元素不等於給定的值 val 時，
我們將它複製到數組的第 j 個位置，同時將 j 增加 1。
這樣就從數組中移除了所有等於 val 的元素。
最後，我們返回 j 的值，這個值表示修改後的數組的長度。
這個解法的時間複雜度是 O(n)，其中 n 是數組的長度。由於我們是原地修改數組，所以空間複雜度是 O(1)。


class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = 0
        while (i < nums.size) {
            if (nums[i] != `val`) {
                nums[j] = nums[i]
                j++
            }
            i++
        }
        return j
    }
}
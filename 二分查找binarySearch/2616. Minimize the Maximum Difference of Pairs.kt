這個問題的目標是在一個整數數組 nums 中，找到一個最小的正整數 maxDiff，使得我們可以從 nums 中移除最多 p 個元素，
從而形成的數組中，相鄰元素之間的差的絕對值不超過 maxDiff。換句話說，我們希望在移除最多 p 個元素的情況下，使得數組中相鄰元素的最大差值（即 maxDiff）變得最小。
為了解決這個問題，我們可以使用二分搜索的方法。首先，我們對 nums 進行排序，以便我們可以更輕鬆地找到相鄰元素之間的差值。
然後，我們定義一個函數 isDiffPoss，該函數用於檢查在給定的 maxDiff 條件下，是否可以在數組中形成至少 p 對相鄰元素差值不超過 maxDiff 的情況。
接下來，我們使用二分搜索來找到符合條件的最小 maxDiff。我們將搜索範圍設置在 1 到 1000000000 之間，並根據 isDiffPoss 函數的結果進行更新。
當我們找到一個符合條件的 maxDiff 時，我們將其儲存，然後將搜索範圍的右邊界向左移動，以尋找更小的 maxDiff。
最終，當二分搜索完成時，我們返回儲存的最小 maxDiff，這就是題目要求的答案。整體來說，
這個問題要求我們找到一個特定條件下的最小最大差值，並且通過二分搜索來逼近這個最小值，同時確保在最多移除 p 個元素的條件下，數組中相鄰元素的差值不超過這個最小值。

class Solution {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        return findMinMax(nums, p)
    }

    private fun findMinMax(nums: IntArray, p: Int): Int {
        nums.sort()
        var left = 0
        var right = 1000000000
        var minMaxD = Int.MAX_VALUE

        while (left <= right) {
            val maxDiff = left + (right - left) / 2

            if (isDiffPoss(nums, p, maxDiff)) {
                minMaxD = maxDiff
                right = maxDiff - 1
            } else {
                left = maxDiff + 1
            }
        }
        return minMaxD
    }

    private fun isDiffPoss(nums: IntArray, p: Int, maxDiff: Int): Boolean {
        val sz = nums.size
        var pCnt = 0

        var indx = 0
        while (indx < sz - 1) {
            if (nums[indx + 1] - nums[indx] <= maxDiff) {
                indx++
                pCnt++
            }
            indx++
        }
        return pCnt >= p
    }
}


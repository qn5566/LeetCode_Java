這道題目要求將兩個已排序的整數數組 nums1 和 nums2 合併成一個已排序的數組 nums1。
我們可以使用雙指針的方法來解決這個問題。
我們將兩個指針 i 和 j 初始化為 nums1 和 nums2 的最後一個元素的索引。
同時，我們還需要一個指針 k 來指向 nums1 的最後一個位置。
我們從後往前遍歷，比較 nums1[i] 和 nums2[j] 的大小，
將較大的元素放到 nums1[k] 的位置上，然後將相應的指針向前移動。
重複這個過程直到其中一個數組的元素都被遍歷完。
如果此時 nums2 還有元素未遍歷完，我們將剩餘的元素依次放到 nums1 的前面。
這是因為 nums1 的前面部分已經是排序好的，所以我們只需要將 nums2 的剩餘元素放到正確的位置即可。
最終，當 nums2 的所有元素都被合併到 nums1 中，即完成了合併排序。
這種解法的時間複雜度是 O(m + n)，其中 m 和 n 分別是 nums1 和 nums2 的長度。
由於我們是原地修改 nums1，所以空間複雜度是 O(1)。


class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]
                i--
            } else {
                nums1[k] = nums2[j]
                j--
            }
            k--
        }

        while (j >= 0) {
            nums1[k] = nums2[j]
            j--
            k--
        }
    }
}

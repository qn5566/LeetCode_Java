
"4. Median of Two Sorted Arrays" 是一个经典的算法问题，要求在两个已排序的数组中找到它们的中位数。这里提供一个 Kotlin 解决方案：

这段代码的核心思想是使用二分查找来找到两个已排序数组的中位数。以下是逐行解释：

1. 首先，确保 nums1 是较短的数组，以确保在二分查找时更容易处理。如果 nums1 长度大于 nums2，则交换它们。
2. 获取 nums1 和 nums2 的长度 m 和 n。
3. 初始化二分查找的范围，imin 表示最小索引，imax 表示最大索引，初始范围为整个 nums1。
4. 计算中位数的位置 halfLen，这是为了处理奇数和偶数情况。
5. 在 while 循环中，进行二分查找。每次迭代中，计算两个分割点 i 和 j，然后根据分割点的情况进行比较和调整。
6. 如果找到合适的分割点，根据奇偶情况计算中位数并返回。
7. 如果没有找到合适的分割点，继续二分查找。
8. 如果循环结束仍未找到中位数，返回默认值 0.0。

这个算法的时间复杂度是 O(log(min(m, n)))，其中 m 和 n 分别是两个输入数组的长度。这个解决方案充分利用了已排序数组的特性，以高效地找到中位数。希望这个解释对你有所帮助。如果你有任何进一步的问题，请随时提问。


class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        // 确保 nums1 是较短的数组
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1)
        }

        var imin = 0
        var imax = m
        val halfLen = (m + n + 1) / 2

        while (imin <= imax) {
            val i = (imin + imax) / 2
            val j = halfLen - i

            if (i < m && nums2[j - 1] > nums1[i]) {
                // 增加 i，缩小 nums1 的区间
                imin = i + 1
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // 减小 i，增大 nums1 的区间
                imax = i - 1
            } else {
                // 找到合适的分割点
                val maxOfLeft: Int
                if (i == 0) {
                    maxOfLeft = nums2[j - 1]
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1]
                } else {
                    maxOfLeft = maxOf(nums1[i - 1], nums2[j - 1])
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft.toDouble()
                }

                val minOfRight: Int
                if (i == m) {
                    minOfRight = nums2[j]
                } else if (j == n) {
                    minOfRight = nums1[i]
                } else {
                    minOfRight = minOf(nums1[i], nums2[j])
                }

                return (maxOfLeft + minOfRight) / 2.0
            }
        }

        return 0.0 // 无法找到中位数，返回默认值
    }
}

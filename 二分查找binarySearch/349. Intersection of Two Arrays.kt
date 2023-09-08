

"349. Intersection of Two Arrays" 是一个求两个数组的交集的问题。问题描述如下：

给定两个整数数组 nums1 和 nums2，返回它们的交集。结果中的每个元素必须是唯一的，而且结果应该以任意顺序返回。

要解决这个问题，可以使用集合（Set）来存储其中一个数组的元素，然后遍历另一个数组，检查元素是否在集合中出现。
如果出现，就将元素添加到结果集合中。

以下是使用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        // 使用集合来存储 nums1 的元素
        val set1 = nums1.toSet()
        
        // 创建一个结果集合，用于存储交集元素
        val resultSet = mutableSetOf<Int>()
        
        // 遍历 nums2，检查元素是否在 set1 中出现
        for (num in nums2) {
            if (set1.contains(num)) {
                resultSet.add(num)
            }
        }
        
        // 将结果集合转换为数组并返回
        return resultSet.toIntArray()
    }
}

在这个代码中，我们首先将 nums1 转换为集合 set1，这样可以快速检查元素是否在 nums1 中出现。

然后，我们创建一个结果集合 resultSet，用于存储交集元素。

接下来，我们遍历 nums2 数组，对于每个元素 num，我们检查它是否在 set1 中出现，如果出现，就将它添加到 resultSet 中。

最后，我们将 resultSet 转换为整数数组并返回结果。

这个算法的时间复杂度取决于集合操作的复杂度，通常是 O(m + n)，其中 m 和 n 分别是 nums1 和 nums2 的长度。
希望这个解释和示例代码有助于理解 "349. Intersection of Two Arrays" 问题的解决方法。
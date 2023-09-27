
要找到数组中的第 k 大元素，可以使用多种方法。以下是一种使用最小堆的 Kotlin 解决方案：

import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>()

    for (num in nums) {
        minHeap.offer(num)
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }

    return minHeap.peek()
}

这段代码创建了一个最小堆（优先队列），然后将数组中的元素逐个添加到堆中。
如果堆的大小超过 k，就弹出堆顶元素，保持堆的大小为 k。最终，堆顶元素就是第 k 大的元素。

你可以调用 findKthLargest(nums, k) 函数来查找第 k 大的元素，
其中 nums 是整数数组，k 是要查找的第 k 大的位置。

请注意，还有其他方法可以解决这个问题，
比如使用快速选择算法或将数组排序后直接找到第 k 大的元素。选择方法取决于具体需求和性能要求。

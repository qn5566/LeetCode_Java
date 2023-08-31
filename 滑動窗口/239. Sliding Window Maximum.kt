239. Sliding Window Maximum 問題是一個滑動窗口的最大值問題。給定一個整數陣列 nums 和一個整數 k，你需要找到每個窗口大小為 k 的子陣列的最大元素。

以下是解決這個問題的一種常見方法，使用雙向佇列（Deque）來保持窗口內元素的遞減順序。

創建一個空的雙向佇列 deque，並創建一個整數陣列 result 來保存每個窗口的最大值。
開始迭代 nums 陣列，對於每個元素 nums[i]：
在進入窗口前，將比 nums[i] 小的元素從 deque 尾部移除，確保 deque 中元素是遞減的。
將 nums[i] 添加到 deque 尾部。
檢查窗口的左邊界是否超出了範圍，如果是，則將 deque 首部的元素移除。
如果窗口大小達到 k，則將 deque 首部的元素（最大元素）加入到 result 陣列中。
返回 result 陣列。
這個方法的主要思想是保持一個遞減的雙向佇列，並始終將窗口內的最大元素保存在雙向佇列的首部。
通過這種方法，我們可以在 O(n) 的時間內求解每個窗口的最大值。


class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>()
        val result = IntArray(nums.size - k + 1)
        
        for (i in nums.indices) {
            // 從佇列尾部移除比目前元素小的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast()
            }
            
            // 將目前元素的索引加入佇列尾部
            deque.offerLast(i)
            
            // 從佇列前部移除超出目前窗口範圍的元素
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst()
            }
            
            // 若已經形成一個完整窗口，將最大元素（佇列前部）加入結果陣列
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()]
            }
        }
        
        return result
    }
}
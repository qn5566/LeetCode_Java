
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * 
這個 swapNodes 函數的目的是在給定的鏈表中交換兩個指定位置的節點。
我們首先遍歷整個鏈表，計算鏈表的長度，這樣我們就可以確定要交換的兩個節點的位置。
接下來，我們使用兩個指針 first 和 second 分別指向要交換的兩個節點，同時使用兩個指針 firstPrev 和 secondPrev 分別指向這兩個節點的前一個節點。
這樣做的目的是為了在交換節點時能夠調整前一個節點的指向。
最後，我們進行節點交換操作。首先，我們檢查 firstPrev 和 secondPrev 是否為空，
如果不為空，則將它們的 next 指向調整為對應的節點。如果為空，則表示要交換的節點是鏈表的頭部，因此需要更新鏈表的頭部指針。
接著，我們進行節點交換。我們將 first 的 next 指向調整為 second 的 next，同時將 second 的 next 指向調整為 first 的原始 next。
最後，我們返回更新後的鏈表頭部。
這個函數的時間複雜度是 O(n)，其中 n 是鏈表的節點數量。它需要遍歷整個鏈表來計算長度和找到要交換的節點，
然後進行節點交換操作。空間複雜度是 O(1)，因為它只使用了有限的指針變量來存儲節點的引用。

在 Kotlin 中，函數參數是唯讀的，也就是不能直接對函數參數進行重新賦值。因此，在 swapNodes 函數中，你無法直接對 head 參數進行重新賦值。
要解決這個問題，你可以使用額外的變量來處理節點的交換。
在進行節點交換時，你可以創建一個新的節點 newHead 並將其初始化為 head，然後對 newHead 進行操作。最後，返回更新後的 newHead。
 */
class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        var newHead = head 

        // 計算鏈表的長度
        var length = 0
        var curr: ListNode? = newHead
        while (curr != null) {
            length++
            curr = curr.next
        }
        
        // 計算要交換的兩個節點的位置
        val firstIndex = k
        val secondIndex = length - k + 1
        
        // 特殊情況處理：如果要交換的兩個節點位置相同，則無需交換
        if (firstIndex == secondIndex) return newHead
        
        // 找到要交換的兩個節點以及它們的前一個節點
        var first: ListNode? = null
        var second: ListNode? = null
        var firstPrev: ListNode? = null
        var secondPrev: ListNode? = null
        
        curr = newHead
        var index = 1
        while (curr != null) {
            if (index == firstIndex) {
                first = curr
            } else if (index == secondIndex) {
                second = curr
            }
            
            if (index == firstIndex - 1) {
                firstPrev = curr
            } else if (index == secondIndex - 1) {
                secondPrev = curr
            }
            
            curr = curr.next
            index++
        }
        
        // 交換兩個節點
        if (first != null && second != null) {
            if (firstPrev != null) {
                firstPrev.next = second
            } else {
                newHead = second
            }
            
            if (secondPrev != null) {
                secondPrev.next = first
            } else {
                newHead = first
            }
            
            val temp = first.next
            first.next = second.next
            second.next = temp
        }
        
        return newHead
    }
}


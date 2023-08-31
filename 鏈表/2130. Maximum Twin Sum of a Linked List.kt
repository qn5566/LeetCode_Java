題目要求找出鏈表中兩個節點值的最大和，這兩個節點需要滿足以下條件：

這兩個節點不相鄰，即它們的位置不相連。
需要選擇不同的節點對。
我們可以使用一個堆疊來處理這個問題。首先，我們將鏈表中的所有節點依序推入堆疊，這樣堆疊中的順序就與鏈表相反了。

接下來，我們使用一個變數 max 來追蹤最大的節點值和。我們同時使用一個指針 head 指向鏈表的頭節點。

然後，我們進行以下操作，直到堆疊的大小為一半（即遍歷到鏈表的中間節點位置）：

每次從堆疊中彈出一個節點，計算當前節點值 head.val 與彈出的節點值之和 head.val + stack.pop().val。
將計算結果與 max 做比較，取較大值更新 max。
移動指針 head 到下一個節點。
最後，返回 max 作為結果，它代表了鏈表中兩個不相鄰節點值的最大和。

請注意，這裡的 ListNode 是指定的節點類型，代表鏈表中的節點，並且假設該類型具有 .next 屬性用於指向下一個節點。


class Solution {
    fun pairSum(head: ListNode?): Int {
        val stack = Stack<ListNode>()
        var headed = head
        var dummy = headed
        while (dummy != null) {
            stack.push(dummy)
            dummy = dummy.next
        }
        var max = 0
        while (stack.size > stack.size / 2) {
            max = maxOf(max, headed!!.`val` + stack.pop().`val`)
            headed = headed.next
        }
        return max
    }
}
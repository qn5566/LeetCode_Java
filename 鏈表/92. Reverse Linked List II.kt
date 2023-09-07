


"92. Reverse Linked List II" 是一个涉及反转链表中特定部分的问题。具体来说，
给定一个链表，要求反转从位置 m 到 n 的元素。例如，对于链表 1 -> 2 -> 3 -> 4 -> 5，
如果 m = 2 且 n = 4，则反转后的链表应为 1 -> 4 -> 3 -> 2 -> 5。
以下是使用 Kotlin 解决这个问题的示例代码：

class Solution {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (head == null) return null
        
        // 使用 dummy 节点简化链表操作
        val dummy = ListNode(0)
        dummy.next = head
        var prev = dummy
        
        // 移动 prev 到反转开始位置的前一个节点
        for (i in 1 until m) {
            prev = prev.next!!
        }
        
        // 开始反转部分的链表头
        val reverseHead = prev.next
        
        // 反转部分链表
        var curr = reverseHead
        var next: ListNode?
        for (i in m until n) {
            next = curr?.next
            curr?.next = next?.next
            next?.next = prev.next
            prev.next = next
        }
        
        return dummy.next
    }
}

这个代码首先创建了一个辅助的 ListNode 类用于构建链表。然后，定义了一个 Solution 类来解决问题。
在 reverseBetween 函数中，我们首先处理特殊情况，如果输入的链表为空，直接返回空。然后，
我们创建一个虚拟头节点 dummy，并将其 next 指向输入链表的头部，这样可以简化链表操作。
接下来，我们要移动 prev 指针到反转部分的前一个节点，也就是第 m-1 个节点。
然后，我们标记反转部分的链表头为 reverseHead。
接下来，我们开始反转链表的部分。具体来说，我们用 curr 指针来迭代每个节点，
将其从反转部分断开，然后将其插入到反转链表的头部。这个过程会迭代 n-m 次。
最后，我们返回虚拟头节点 dummy 的 next，这是反转链表后的新链表的头。

这个算法的时间复杂度是 O(n)，其中 n 是链表的长度，因为我们只遍历了链表一次。
希望这个解释和示例代码有助于理解 "92. Reverse Linked List II" 问题的解决方法。
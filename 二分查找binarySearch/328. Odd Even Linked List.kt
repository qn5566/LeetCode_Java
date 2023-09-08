
"328. Odd Even Linked List" 是一个链表操作问题。问题描述如下：

给定一个单链表，将所有的奇数节点和偶数节点分别排在一起，使得所有的奇数节点在前，偶数节点在后。
请注意，这里的奇数和偶数是指节点的位置，而不是节点的值。

例如，给定链表 1->2->3->4->5->NULL，将其重新排列为 1->3->5->2->4->NULL。

要解决这个问题，你可以按照以下步骤操作：

1. 创建两个新的链表，一个用于存储奇数节点，一个用于存储偶数节点。
2. 遍历原始链表，将奇数位置的节点连接到奇数链表，将偶数位置的节点连接到偶数链表。
3. 最后，将奇数链表的尾部连接到偶数链表的头部，完成奇数节点和偶数节点的合并。

以下是使用 Kotlin 解决这个问题的示例代码：

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        
        val oddHead = ListNode(-1) // 奇数链表的头节点
        val evenHead = ListNode(-1) // 偶数链表的头节点
        var oddTail = oddHead // 奇数链表的尾节点
        var evenTail = evenHead // 偶数链表的尾节点
        
        var isOdd = true // 标记当前节点是奇数节点还是偶数节点
        var current = head // 当前遍历的节点
        
        while (current != null) {
            if (isOdd) {
                oddTail.next = current
                oddTail = oddTail.next!!
            } else {
                evenTail.next = current
                evenTail = evenTail.next!!
            }
            
            isOdd = !isOdd
            current = current.next
        }
        
        // 将奇数链表的尾部连接到偶数链表的头部
        oddTail.next = evenHead.next
        evenTail.next = null // 断开偶数链表的尾部
        
        return oddHead.next // 返回合并后的链表头部
    }
}

在这个代码中，我们首先检查特殊情况，如果链表为空或只有一个节点，直接返回原始链表。

然后，我们创建了两个新的链表 oddHead 和 evenHead，分别用于存储奇数节点和偶数节点。
同时，我们维护了指向奇数链表和偶数链表尾部的指针 oddTail 和 evenTail。

我们使用 isOdd 变量来标记当前节点是奇数节点还是偶数节点，并遍历原始链表。根据 isOdd 的值，
我们将当前节点连接到奇数链表或偶数链表，并更新相应的链表尾部指针。

最后，我们将奇数链表的尾部连接到偶数链表的头部，并断开偶数链表的尾部。最后返回合并后的链表头部。

这个算法的时间复杂度是 O(n)，其中 n 是链表的长度，因为我们需要遍历整个链表。
希望这个解释和示例代码有助于理解 "328. Odd Even Linked List" 问题的解决方法。
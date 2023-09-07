"725. Split Linked List in Parts" 是一个链表问题，要求将给定的链表分割成 k 个连续的部分。
如果链表无法均匀分割，应该将额外的节点分配给前面的部分。每个部分的大小应尽可能相等，并且按照原始链表的顺序排列。

以下是使用 Kotlin 解决这个问题的示例代码：

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        // 计算链表长度
        var len = 0
        var current = root
        while (current != null) {
            len++
            current = current.next
        }
        
        // 计算每个部分的大小和余数
        val partSize = len / k  // 每个部分的大小
        val extraNodes = len % k  // 余数，用于分配到前面的部分
        
        val result = arrayOfNulls<ListNode>(k)
        current = root
        var prev: ListNode? = null
        for (i in 0 until k) {
            result[i] = current
            val currentPartSize = partSize + if (i < extraNodes) 1 else 0  // 当前部分的大小
            for (j in 0 until currentPartSize) {
                prev = current
                current = current?.next
            }
            if (prev != null) {
                prev.next = null  // 切断当前部分的尾节点
            }
        }
        
        return result
    }
}

这个代码首先遍历链表计算其长度。然后，根据长度计算每个部分的大小和余数。
接下来，使用循环将链表分割成 k 个部分，并在每个部分之间切断连接。最后，将结果存储在数组中并返回。
这个算法的时间复杂度为 O(n)，其中 n 是链表的长度。希望这个代码可以帮助你解决 "725. Split Linked List in Parts" 问题。
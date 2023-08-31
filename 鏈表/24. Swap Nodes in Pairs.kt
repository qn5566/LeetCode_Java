Swap Nodes in Pairs 是一個關於鏈表操作的問題。給定一個單鏈表，要求將相鄰的兩個節點進行交換，並返回交換後的新鏈表。
例如，對於鏈表 1 -> 2 -> 3 -> 4，
我們需要將節點 1 和節點 2 進行交換，節點 3 和節點 4 進行交換，最終得到鏈表 2 -> 1 -> 4 -> 3。
這個問題可以使用遞迴或迭代的方式解決。一種常見的解法是使用迭代，通過設置指針來進行節點的交換。具體步驟如下：

初始化一個虛擬節點 dummy，將其指向鏈表的頭節點。
定義兩個指針 prev 和 curr，初始時 prev 指向 dummy，curr 指向頭節點。
進行迭代遍歷，每次處理兩個相鄰的節點：
將 prev 的下一個節點指向 curr 的下一個節點，即 prev.next = curr.next。
將 curr 的下一個節點指向 curr 的下下個節點，即 curr.next = curr.next.next。
將 prev 的下一個節點的下一個節點指向 curr，即 prev.next.next = curr。
更新 prev 和 curr 的位置，將 prev 移動到下一組要交換的節點的前一個節點，curr 移動到下一組要交換的節點的第一個節點。
返回虛擬節點 dummy 的下一個節點，即交換後的新鏈表的頭節點。
這個解法的時間複雜度是 O(n)，其中 n 是鏈表的長度，因為我們需要遍歷整個鏈表進行節點的交換操作。


class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        // 如果鏈表為空或只有一個節點，則無需進行交換，直接返回 head
        if (head == null || head.next == null) {
            return head
        }
        
        // 定義一個虛擬節點 dummy 作為新的頭節點
        val dummy = ListNode(0)
        dummy.next = head
        
        // 定義指針指向 dummy
        var prev: ListNode? = dummy
        
        // 進行節點交換，每次交換兩個節點
        while (prev?.next != null && prev.next?.next != null) {
            val first = prev.next // 第一個節點
            val second = prev.next?.next // 第二個節點
            
            // 進行節點交換
            first?.next = second?.next
            second?.next = first
            prev.next = second
            
            // 更新 prev 指針
            prev = first
        }
        
        // 返回交換後的鏈表頭節點
        return dummy.next
    }
}
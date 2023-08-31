## 141. 環形鏈表

### 問題描述

給定一個鏈表，判斷鏈表中是否有環。

為了表示給定鏈表中的環，我們使用一個整數 `pos` 來表示鏈表尾部連接到鏈表中的位置（索引從 0 開始）。 如果 `pos` 是 -1，則在該鏈表中沒有環。

### 範例

**輸入：** `head = [3,2,0,-4], pos = 1`

**輸出：** `true`

**解釋：**
鏈表中存在一個環，尾部連接到第二個節點。

### 思路

我們可以使用 Floyd's Tortoise and Hare 算法來檢測鏈表中是否有環。該算法涉及兩個指針 - 慢指針和快指針。慢指針每次移動一步，而快指針每次移動兩步。如果鏈表有環，快指針最終會追上慢指針。

### 代碼實現

以下是 Kotlin 代碼實現：

```
fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next

    while (fast != null && fast.next != null) {
        if (slow == fast) {
            return true
        }

        slow = slow?.next
        fast = fast.next?.next
    }

    return false
}

```

### 复杂度分析

時間複雜度：$O(N)$，其中 $N$ 是鏈表中的節點數。Floyd's 算法需要 $O(N)$ 的時間來檢測鏈表中的環。

空間複雜度：$O(1)$。我們只使用了常量級別的額外空間。

# Leetcode
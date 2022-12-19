package 鍊錶;

import TowPoint雙指針.ListNode;

/**
 * 使用遞歸
 * 
 * 現在的val 是否等於 下一個val
 * head.val == head.next.val ? head.next : head;
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}

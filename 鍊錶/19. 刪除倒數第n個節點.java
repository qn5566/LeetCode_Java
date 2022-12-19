package 鍊錶;

import TowPoint雙指針.ListNode;

/**
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 时间复杂度为 O(N)，空间复杂度为 O(1)。如果不存在交点则返回 null
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 先把fast的值 定義到n位
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        // 再一起往前 等fast == null 的時候 slow 就是要刪的值
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 刪除slow的next值
        slow.next = slow.next.next;
        return dummy.next;
    }
}

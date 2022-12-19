package 鍊錶;

import TowPoint.ListNode;

/**
 * 遞歸解法
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            // 保存下一個節點
            temp = cur.next;
            // 反轉結點到prev
            cur.next = prev;
            // 在互相延續
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}

/**
 * 头插法
 */
class Solution_2 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
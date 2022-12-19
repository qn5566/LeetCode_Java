package 二分查找binarySearch;

import TowPoint雙指針.ListNode;

/**
 * 快慢指針求中位數
 * 
 */
class Solution {
    public ListNode middleNode(ListNode head) {
         ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

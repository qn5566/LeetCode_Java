package 二分查找binarySearch;

import TowPoint雙指針.ListNode;

/**
 * 快慢指針標準題目
 * 
 * 因為題目是標準單偶替換
 * You must solve the problem in O(1) extra space complexity and O(n) time
 * complexity.
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode evenHead = head.next;
        ListNode evenNode = evenHead;
        ListNode oddNode = head;
        while (oddNode.next != null && evenNode.next != null) {
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }
}

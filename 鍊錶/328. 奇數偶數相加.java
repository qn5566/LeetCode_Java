package 鍊錶;

import TowPoint.ListNode;

/**
 * odd 奇數
 * even 偶數
 * 給你一個ListNode，把輸入的listNode分成奇、偶Node，再重組，第一個值為奇數Node，第二個值為偶數Node
 * 
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        // odd 就是奇數代表 evenHead 就是偶數代表
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
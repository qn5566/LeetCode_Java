package 鍊錶;

import TowPoint雙指針.ListNode;

/**
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 1跟2交換 3跟4交換
 * 
 * 重點 原本 head.next.next 的節點 指向3 要改成只為1 喔
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        // 要先判斷有沒有2個
        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next; // 将 prev 的 next 改为 head 的 next
            head.next.next = head; // 将 head.next(prev.next) 的next，指向 head
            head.next = temp; // 将head 的 next 接上缓存的temp

            prev = head; // 步进1位
            head = head.next; // 步进1位
        }
        return dummyNode.next;
    }
}

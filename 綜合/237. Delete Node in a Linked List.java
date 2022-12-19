package 綜合;

import TowPoint雙指針.ListNode;

/**
 * 就是很簡單的刪除listNode模式
 * 下一個復值給現在
 * 現在的next復職下下一個
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode p = node;
        p.val = p.next.val;
        p.next = p.next.next;     
    }
}

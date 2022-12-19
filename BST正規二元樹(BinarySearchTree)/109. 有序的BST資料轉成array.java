package BST正規二元樹;

import BinaryTree二元樹.TreeNode;
import TowPoint.ListNode;

/**
 * 先找出中間的點
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null; // 断开链表

        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }

    /**
     * 用快慢指針的方式尋找
     * 
     * @param head
     * @return
     */
    private ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}

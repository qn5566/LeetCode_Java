package 鍊錶;

import TowPoint.ListNode;

/**
 * 题目要求：以 O(1) 的空间复杂度来求解。
 * 切成两半，把后半段反转，然后比较两半是否相等。
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * Input: head = [1,2]
 * Output: false
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head.next;

        // 找中點分成一半
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果fast不是null 讓slow指向下一個節點可以整除
        // 1 2 3 4 5 fast 剛好在5 那 slow只到3就是中點
        if (fast != null)
            slow = slow.next; // 偶数节点，让 slow 指向下一个节点
        cut(head, slow); // 切成两个链表
        return isEqual(head, reverse(slow));
    }

    // 剪半
    private void cut(ListNode head, ListNode cutNode) {
        while (head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }

    // 倒轉是否相等
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}

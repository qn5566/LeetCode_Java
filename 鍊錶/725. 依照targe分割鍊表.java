package 鍊錶;

import TowPoint.ListNode;

/**
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference
 * at most 1, and earlier parts are a larger size than the later parts.
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        // 統計有幾的值
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        // 算出組平均的餘數
        int mod = N % k;

        // 算出組平均
        int size = N / k;
        ListNode[] ret = new ListNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ret[i] = cur;
            // (mod-- > 0 ? 1 : 0) 表示平均分配
            // 如果餘數有大於0 就+1
            // 並且-- 可以給下一個區間數
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }
}

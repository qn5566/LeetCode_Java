package 滑動窗口;

import java.util.ArrayDeque;

/**
 * 群找k個裡面的最大值
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position Max
 * --------------- -----
 * [1 3 -1] -3 5 3 6 7 3
 * 1 [3 -1 -3] 5 3 6 7 3
 * 1 3 [-1 -3 5] 3 6 7 5
 * 1 3 -1 [-3 5 3] 6 7 5
 * 1 3 -1 -3 [5 3 6] 7 6
 * 1 3 -1 -3 5 [3 6 7] 7
 * 
 * 使用Deque
 * 雙向排列 滑動窗口常用
 * Deque<Integer> deque = new LinkedList<Integer>();
 * deque.offerFirst(i) // 加在頭部
 * deque.offerLast(i) // 加在尾部
 * deque.peekFirst(); // 返回第一個值
 * deque.peekLast(); // 返回最後一個值
 * deque.pollFirst(); // 刪除第一個值
 * deque.pollLast(); // 刪除最後一個值
 * 
 * Time : O(n)
 * S : O(k)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {

            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                // 刪除第一個
                deque.poll();
            }

            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                // 刪除最後一個
                deque.pollLast();
            }

            // 新增進去
            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i >= k - 1) {
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
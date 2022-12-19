package 綜合;

import java.util.Stack;

/**
 * 計算所以數列裡面的最小值相加
 * 
 * 好難
 * https://www.youtube.com/watch?v=pS5PaqXa78k&ab_channel=%E4%BB%8A%E5%A4%A9%E6%AF%94%E6%98%A8%E5%A4%A9%E5%8E%B2%E5%AE%B3
 * 
 */
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        int len = arr.length;
        int mod = (int) 1e9 + 7;
        // cc
        if (arr == null || len == 0)
            return (int) res;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; i++) {
            int curr = i < len ? arr[i] : -1;

            while (!stack.isEmpty() && arr[stack.peek()] > curr) {
                int right = stack.pop();
                int left = stack.isEmpty() == true ? -1 : stack.peek();
                res += (long) (right - left) * (i - right) * arr[right];
            }
            stack.push(i);
        }
        res = res % mod;
        return (int) res;
    }
}

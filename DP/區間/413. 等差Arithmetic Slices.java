package DP.區間;

/**
 * 經典等差計算
 * dp[2] = 1
 * [0, 1, 2]
 * dp[3] = dp[2] + 1 = 2
 * [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
 * [1, 2, 3] // 新的递增子区间
 * dp[4] = dp[3] + 1 = 3
 * [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
 * [1, 2, 3, 4], // [1, 2, 3] 之后加一个 4
 * [2, 3, 4] // 新的递增子区间
 * 综上，在 A[i] - A[i-1] == A[i-1] - A[i-2] 时，dp[i] = dp[i-1] + 1。
 * 
 * 
 * A = [0, 1, 2, 3, 4]
 * 
 * return: 6, for 3 arithmetic slices in A:
 * 
 * [0, 1, 2],
 * [1, 2, 3],
 * [0, 1, 2, 3],
 * [0, 1, 2, 3, 4],
 * [ 1, 2, 3, 4],
 * [2, 3, 4]
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];

        // nums[i] - nums[i-1] = nums[i-2] - nums[i-1];
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int total = 0;
        for (int cnt : dp) {
            total += cnt;
        }
        return total;
    }
}

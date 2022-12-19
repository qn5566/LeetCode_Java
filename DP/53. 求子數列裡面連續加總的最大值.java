package DP;

/**
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // 給一個res做對大值的紀錄
        int res = nums[0];

        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}

package 滑動窗口;

/**
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 此題為滑動窗口標準寫法
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 設定最大值防止有0或是空值
        int left = 0, result = Integer.MAX_VALUE, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                // 更新最小長度
                result = Math.min(result, right - left + 1);
                // 更新左邊的指針
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

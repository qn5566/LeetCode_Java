package 綜合;

/**
 * ex:1
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index.
 * 
 * ex2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { // 遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

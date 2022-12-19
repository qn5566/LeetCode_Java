package DP.最长摆动子序列;

/**
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is
 * [1,17,10,13,10,16,8].
 * 
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 
 * 
 * 一個陣列數據做正負交叉排列
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1, down = 1; // 因為不知道上下誰先 所以先定義 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // 當現在的數比較大 up + 1
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) { // 反之 down + 1
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
package TowPoint雙指針;

/**
 * 範例：
 * nums = [3, 1, 2, 3, 2]， val = 3
 * 應該要return 陣列的長度3，因為裡面的3被移除後剩[1,2,2].
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow;
        for (slow = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

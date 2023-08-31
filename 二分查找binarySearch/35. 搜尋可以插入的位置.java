package 二分查找binarySearch;

/**
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = 1 + mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}

class Solution2 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = nums.length - 1;
        int index = -1;

        while (i <= j) {
            index = (i + j) / 2;
            if (nums[index] == target)
                return index;
            if (nums[index] > target)
                j = index - 1;
            else
                i = index + 1;
        }
        return i;
    }
}

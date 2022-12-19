package 二分查找binarySearch;

/**
 * 找出最小值
 * 
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * 
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4
 * times.
 * 
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 * 
 * 利用已經好排序的特性
 * 用分治法去做
 */
class Solution_new {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        // 元素個數只有1 or 2個
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }

        // 確認是已經否排序過的
        if (nums[left] < nums[right]) {
            return nums[left]; // 直接給最小值
        }

        // 直接做排序
        int mid = left + (right - left) / 2;

        return Math.min(findMin(nums, left, mid - 1), findMin(nums, mid, right));
    }
}

/**
 * 這是一班用快速排序的方式計算
 * time : O(n)
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
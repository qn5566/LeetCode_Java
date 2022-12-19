package 二分查找binarySearch;

/**
 * 题目描述：给定一个有序数组 nums 和一个目标 target，
 * 要求找到 target 在 nums 中的第一个位置和最后一个位置。
 * 
 * 可以用二分查找找出第一个位置和最后一个位置，
 * 但是寻找的方法有所不同，需要实现两个二分查找。
 * 我们将寻找 target 最后一个位置，转换成寻找 target+1 第一个位置，再往前移动一个位置。
 * 这样我们只需要实现一个二分查找代码即可。
 * 
 * 尋找target的數值在array的兩個前後位置
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        ans[0] = binarySearch(nums, target, true);
        if (ans[0] != -1)
            ans[1] = binarySearch(nums, target, false);
        return ans;
    }

    public int binarySearch(int nums[], int target, boolean isFirstSearch) {
        int ans = -1;
        int start = 0, end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid])
                start = mid + 1;
            else if (target < nums[mid])
                end = mid;
            else {
                ans = mid;
                if (isFirstSearch) {
                    // 先抓後面那一個
                    end = mid;
                    // 在搜一次另外一個
                } else {
                    // 這樣等等就跳出
                    start = mid + 1;
                }

            }
        }

        return ans;
    }
}
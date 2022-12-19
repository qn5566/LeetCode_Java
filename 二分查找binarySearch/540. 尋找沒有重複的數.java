package 二分查找binarySearch;

/**
 * 尋找有序的數組裡面唯一沒有重複的數
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1; // 7
        while (l < r) {
            int m = l + (r - l) / 2; // 3
            if (m % 2 == 1) {
                m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}

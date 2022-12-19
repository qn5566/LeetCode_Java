package DP.最长递增子序列;

/**
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101],
 * therefore the length is 4.
 * 
 * 在正列裡面的數據資料可以排成最長的遞增資料是多少
 * 
 * dp
 * T O(n2)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}

/**
 * 定义一个 tails 数组，其中 tails[i] 存储长度为 i + 1 的最长递增子序列的最后一个元素。
 * 对于一个元素 x，
 * 
 * 如果它大于 tails 数组所有的值，那么把它添加到 tails 后面，
 * 表示最长递增子序列长度加 1；
 * 如果 tails[i-1] < x <= tails[i]，那么更新 tails[i] = x。
 * 例如对于数组 [4,3,6,5]，有：
 * 
 * tails len num
 * [] 0 4
 * [4] 1 3
 * [3] 1 6
 * [3,6] 2 5
 * [3,5] 2 null
 * 可以看出 tails 数组保持有序，因此在查找 Si 位于 tails 数组的位置时就可以使用二分查找。
 * 
 * 
 */

class Solution_2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

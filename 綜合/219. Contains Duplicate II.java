package 綜合;

import java.util.HashMap;

/**
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 這題主要是說數列裡面的值有相等且相減<=k的條件
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int pre = map.get(nums[i]);
                if (i - pre <= k)
                    return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}

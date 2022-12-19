package 綜合;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up
 * to 6.
 * 
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose
 * elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * 
 * 
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            int r = s % k;
            if (mp.containsKey(r) && i - mp.get(r) >= 2) {
                return true;
            }
            if (!mp.containsKey(r)) {
                mp.put(r, i);
            }
        }
        return false;
    }
}

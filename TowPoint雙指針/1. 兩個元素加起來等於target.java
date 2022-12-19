package TowPoint雙指針;

import java.util.HashMap;
import java.util.Map;

/**
 * 給一個裡面元素為int的陣列，陣列中會有兩個元素加起來等於target，回傳這兩個元素的位置。
 * 
 * 範例：
 * [2, 7, 11, 15], target = 9，2+7=9，因此回傳[1,2]
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

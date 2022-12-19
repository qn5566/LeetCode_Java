package TowPoint雙指針;

import java.util.HashMap;
import java.util.Map;

/**
 * 因为最多只需要遍历一次 0~sqrt(target)，
 * 所以时间复杂度为 O(sqrt(target))。又因为只使用了两个额外的变量，因此空间复杂度为 O(1)。
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
                res[1] = i + 1;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i + 1);
        }
        return res;
    }
}
package TowPoint雙指針;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度为 O(N)。
 * 只使用了两个额外变量，空间复杂度为 O(1)。
 * 
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 先定義一個正列
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 讓target - nums[i] 找出另外一個
        // 在用Map 做存取判斷
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

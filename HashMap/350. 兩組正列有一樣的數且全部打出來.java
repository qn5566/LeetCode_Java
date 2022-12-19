package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        // 先存數據在map裡面
        for (Integer i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 在跟第二組數據做判斷
        // 有值的話加到list裡面，並更新map的值-1
        // count這個是判斷有沒有值
        for (Integer i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count != 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
package 綜合;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 數據正列只能有唯一值
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap();

        for (int num : arr) {
            int oldCount = counts.getOrDefault(num, 0);
            counts.put(num, oldCount + 1);
        }

        Set<Integer> seen = new HashSet();

        for (int occurrence : counts.values()) {
            if (seen.contains(occurrence)) {
                return false;
            }

            seen.add(occurrence);
        }
        return true;
    }
}
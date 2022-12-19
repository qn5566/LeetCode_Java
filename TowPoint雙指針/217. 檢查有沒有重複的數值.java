package TowPoint雙指針;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: [1,2,3,1]
 * Output: true
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * 
 * 簡單來說，只要 Array 中有重複出現的數字就回傳 true，如果都沒有重複就回傳 false。
 * 
 * Time complexity: O(n)
 * Space complexity: O(n) (Hash Table 佔掉的空間會隨 nums 大小上升)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}

/**
 * 暴力法 Brute Force — Naive Linear Search
 * 
 * Time complexity: O(n²)
 * Space complexity: O(1)
 * 第一個最暴力解就是用兩個 loops 下去一一比對，
 * 如果抓到有一樣的就 return true，
 * 如果都沒有抓到就在最後 return
 * false。此解法會超時無法通過
 */
class Solution_BF {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] == nums[i])
                    return true;
            }
        }
        return false;
    }
    // Time Limit Exceeded
}

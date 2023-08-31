package 綜合;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑動窗口
 * Fruit Into Baskets
 * 規定只能放兩種水果
 * 求最多可以放幾個
 * 
 * ex1:
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * 
 * ex2:
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * 
 * ex3:
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 */
class Solution {
    public int totalFruit(int[] tree) {
        int ans = 0;
        // 設定籃子
        Map<Integer, Integer> count = new HashMap<>();

        // 左邊 l , 右邊 r
        for (int l = 0, r = 0; r < tree.length; ++r) {
            count.put(tree[r], count.getOrDefault(tree[r], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[l], count.get(tree[l]) - 1);
                count.remove(tree[l], 0);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}

package Google經典題目;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入： {1,2,3,4,5}
 * 输出： [[4, 5, 3], [2], [1]].
 * 
 * 输入： {1,2,3,4}
 * 输出： [[4, 3], [2], [1]].
 * 用一個 Map<Integer, List<Integer>> 去紀錄每一層的數值
 */
class Solution {
    /**
     * @param root the root of binary tree
     * @return collect and remove all leaves
     */

    int dfs(TreeNode cur, Map<Integer, List<Integer>> depth) {
        if (cur == null) {
            return 0;
        }
        int d = Math.max(dfs(cur.left, depth), dfs(cur.right, depth)) + 1;

        depth.putIfAbsent(d, new ArrayList<>());
        depth.get(d).add(cur.val);
        return d;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, List<Integer>> depth = new HashMap<>();
        int max_depth = dfs(root, depth);

        for (int i = 1; i <= max_depth; i++) {
            ans.add(depth.get(i));
        }
        return ans;
    }
}

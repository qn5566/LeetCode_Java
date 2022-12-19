package DP.強劫;

import java.util.HashMap;
import java.util.Map;

import BinaryTree二元樹.TreeNode;

/**
 * 定義一個Map儲存訪問過的節點把資料存起來
 * 在定義一個2個val 分別比較第一種和第二種的答案
 * 
 * Example 1:
 * 
 * 3
 * / \ 
 * 2 3
 * \ \
 * 3 1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * 
 * 
 * Example 2:
 * 
 * 3
 * / \
 * 4 5
 * / \ \
 * 1 3 1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
class Solution {
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (cache.containsKey(root))
            return cache.get(root);
        int val1 = root.val;
        if (root.left != null)
            val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        int res = Math.max(val1, val2);
        cache.put(root, res);
        return res;
    }
}

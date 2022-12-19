package BinaryTree二元樹;

/**
 * 使用dfs的方式計算
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {

        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int mn, int mx) {
        if (node == null)
            return mx - mn;
        mn = Math.min(mn, node.val);
        mx = Math.max(mx, node.val);
        return Math.max(helper(node.left, mn, mx), helper(node.right, mn, mx));
    }

}

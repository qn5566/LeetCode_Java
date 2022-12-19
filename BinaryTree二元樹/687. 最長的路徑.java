package BinaryTree二元樹;

/**
 * 先定義一個常數path 記錄路徑值
 * 在用dfs搜尋左右路徑有沒有連續
 * root.left.val == root.val 左邊的值 == 自己的值
 * 如果有就+1
 * 沒有的話就歸零
 */
class Solution {
    private int path = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}

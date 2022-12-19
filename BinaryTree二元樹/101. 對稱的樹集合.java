package BinaryTree二元樹;

/**
 * 1
 * / \
 * 2 2
 * / \ / \
 * 3 4 4 3
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        // 左邊跟右邊同時null的話是對的
        if (t1 == null && t2 == null)
            return true;

        // 左邊跟右邊不同時null的話是不對的
        if (t1 == null || t2 == null)
            return false;

        // 左邊跟右邊的val不一樣的話是不對的
        if (t1.val != t2.val)
            return false;

        // 繼續遞歸
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
}

package BinaryTree二元樹;

/**
 * 求完整二叉樹所有的節點
 * 
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * 
 * Input: root = []
 * Output: 0
 * 
 * Input: root = [1]
 * Output: 1
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);

        if (l == r) {
            return (1 << l) + countNodes(root.right);
        } else {
            return (1 << (l - 1)) + countNodes(root.left);
        }
    }

    // 計算此二叉樹的高度，因為只計算左邊
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + height(root.left);
    }
}
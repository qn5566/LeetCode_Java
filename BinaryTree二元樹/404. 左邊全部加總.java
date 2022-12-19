package BinaryTree二元樹;

/**
 * 計算左邊全部的總和
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (isLeaf(root.left)) {
            // 左邊相加
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        // 左右確認
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * 確認是否是左邊 // 還有沒有值
     * 
     * @param node
     * @return
     */
    private boolean isLeaf(TreeNode node) {
        if (node == null)
            return false;
        return node.left == null && node.right == null;
    }
}

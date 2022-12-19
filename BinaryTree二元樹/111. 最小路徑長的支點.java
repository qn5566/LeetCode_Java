package BinaryTree二元樹;

/**
 * 深度計算方法
 * 只要root == 0 就+1
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * 
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0)
            return left + right + 1; // 加深度 1
        return Math.min(left, right) + 1;
    }
}
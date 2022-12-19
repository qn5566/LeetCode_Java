package BinaryTree二元樹;

/**
 * 這題會用到之前寫過的LeetCode 104. Maximum Depth of Binary Tree
 * 尋找node左樹的深度與右樹的深樹後相減，如果差超過1，表示非高度平衡樹
 * 如果沒差超過1，傳入左節點與右節點繼續判斷是否為高度平衡樹
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (checkDepth(root) == -1) {
            return false;
        }
        return true;
    }

    private int checkDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 取左邊
        int l = checkDepth(root.left);
        if (l == -1) {
            return -1;
        }
        // 取右邊
        int r = checkDepth(root.right);
        if (r == -1) {
            return -1;
        }
        // 相減大於1 就不是平衡樹
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}

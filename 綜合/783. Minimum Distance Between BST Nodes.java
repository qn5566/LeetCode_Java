package 綜合;

import BinaryTree二元樹.TreeNode;

/**
 * 求正規二元樹他們最小差異的值
 * 
 * ex1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * 
 * ex2:
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 */
class Solution {
    Integer prev = null;
    int diff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return -1;
        help(root);

        return diff;
    }

    public void help(TreeNode root) {
        if (root == null)
            return;

        help(root.left);

        if (prev == null) {
            prev = root.val;
        } else {
            diff = Math.min(diff, root.val - prev);
            prev = root.val;
        }

        help(root.right);
    }
}

package BST正規二元樹;

import BinaryTree二元樹.TreeNode;

/**
 * 定義兩個值
 * cnt 存順序
 * val 存答案
 * 
 */
class Solution {
    private int cnt = 0;
    private int val;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null)
            return;
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}

/**
 * 遞歸解法
 */
class Solution_2 {
    public int kthSmallest(TreeNode root, int k) {
        int leftCnt = count(root.left);
        if (leftCnt == k - 1)
            return root.val;
        if (leftCnt > k - 1)
            return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - leftCnt - 1);
    }

    private int count(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
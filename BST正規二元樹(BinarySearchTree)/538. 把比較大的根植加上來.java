package BST正規二元樹;

import BinaryTree二元樹.TreeNode;

/**
 * 主要是把自己的值還要大得值都加起來
 * 可以用中序遍歷
 * 從右邊然後中間再到左邊坐遍歷
 * 因為值永遠是最大的
 */
class Solution {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private void traver(TreeNode node) {
        if (node == null)
            return;
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }
}

package BST正規二元樹;

import Google經典題目.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Case 1: when one of node is root
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Case 2: when both the nodes are in right subtree
        if (left == null) {
            return right;
        }

        // Case 3: when both the nodes are in left subtree
        if (right == null) {
            return left;
        }

        // Case 4: one node is in left subtree and other is in right subtree then LCA is
        // root
        return root;

        // 也可以這樣寫
        // return left == null ? right : right == null ? left : root;
    }
}
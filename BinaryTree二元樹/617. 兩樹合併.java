package BinaryTree二元樹;

/**
 * Input:
 * Tree 1 Tree 2
 * 1 2
 * / \ / \
 * 3 2 1 3
 * / \ \
 * 5 4 7
 * 
 * Output:
 * 3
 * / \
 * 4 5
 * / \ \
 * 5 4 7
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}

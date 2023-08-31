package BinaryTree二元樹;

/**
 * 判斷是不是一樣的樹
 * ex1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * 
 * ex2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * 
 * ex3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * 
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

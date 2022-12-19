package BinaryTree二元樹;

/**
 * 这道题让我们求一个数是否是另一个树的子树，从题目中的第二个例子中可以看出，子树必须是从叶结点开始的，
 * 中间某个部分的不能算是子树，那么我们转换一下思路，是不是从s的某个结点开始，跟t的所有结构都一样，
 * 那么问题就转换成了判断两棵树是否相同，也就是Same
 * Tree的问题了，这点想通了其实代码就很好写了，用递归来写十分的简洁，我们先从s的根结点开始，跟t比较，
 * 如果两棵树完全相同，那么返回true，否则就分别对s的左子结点和右子结点调用递归再次来判断是否相同，只要有一个返回true了，就表示可以找得到。
 * 
 * Example 1:
 * Given tree s:
 * 
 * 3
 * / \
 * 4 5
 * / \
 * 1 2
 * Given tree t:
 * 
 * 4
 * / \
 * 1 2
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * 
 * Example 2:
 * Given tree s:
 * 
 * 3
 * / \
 * 4 5
 * / \
 * 1 2
 * /
 * 0
 * Given tree t:
 * 
 * 4
 * / \
 * 1 2
 * Return false.
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null)
            return true;
        if (t == null || s == null)
            return false;
        if (t.val != s.val)
            return false;
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}
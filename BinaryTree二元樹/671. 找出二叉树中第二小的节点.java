package BinaryTree二元樹;

/**
 * 一个节点要么具有 0 个或 2 个子节点，如果有子节点，那么根节点是最小的节点。
 * 道题让我们找二叉树中的第二小的结点值，并且给该二叉树做了一些限制，
 * 比如对于任意一个结点，要么其没有子结点，要么就同时有两个子结点，
 * 而且父结点值是子结点值中较小的那个，当然两个子结点值可以相等。那么直接上暴力搜索呗，
 * 根据该树的附加条件可知，根结点一定是最小的结点值first，
 * 那么我们只要找出第二小的值second即可，初始化为整型的最大值。
 * 然后对根结点调用递归函数，将first和second当作参数传进去即可。
 * 在递归函数中，如果当前结点为空，直接返回，若当前结点孩值不等于first，
 * 说明其肯定比first要大，然后我们看其是否比second小，小的话就更新second，
 * 然后对当前结点的左右子结点分别调用递归函数即可，参见代码如下：
 * 
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return -1;
        int left = root.left.val;
        int right = root.right.val;
        if (left == root.val)
            left = findSecondMinimumValue(root.left);
        if (right == root.val)
            right = findSecondMinimumValue(root.right);
        if (left != -1 && right != -1)
            return Math.min(left, right);
        if (left != -1)
            return left;
        return right;
    }
}

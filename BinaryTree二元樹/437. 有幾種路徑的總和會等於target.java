package BinaryTree二元樹;

/**
 * 請問有幾種路徑等於target
 * 
 * 這種都適用dfs去遍歷
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * 10
 * / \
 * 5 -3
 * / \ \
 * 3 2 11
 * / \ \
 * 3 -2 1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1. 5 -> 3
 * 2. 5 -> 2 -> 1
 * 3. -3 -> 11
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        if (root.val == sum) {
            ret++;
        }

        // 路径不一定以 root 开头，也不一定以 leaf 结尾，但是必须连续。
        ret += pathSumStartWithRoot(root.left, sum - root.val) +
                pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}

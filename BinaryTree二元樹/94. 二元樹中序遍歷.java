package BinaryTree二元樹;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 左中右
 * 
 * void dfs(TreeNode root) {
 * dfs(root.left);
 * visit(root);
 * dfs(root.right);
 * }
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
}

class Solution_new {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}

package BinaryTree二元樹;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历为 root -> left -> right，
 * 后序遍历为 left -> right -> root。
 * 可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反。
 * 
 * 
 */

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            ret.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}

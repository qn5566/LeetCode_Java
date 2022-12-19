package BinaryTree二元樹;

/**
 * Input: Binary tree: [1,2,3,4]
 * 1
 * / \
 * 2 3
 * /
 * 4
 * 
 * Output: "1(2(4))(3)"
 */
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder answer = new StringBuilder();
        treeToString(root, answer);
        return answer.toString();
    }

    private void treeToString(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }
        result.append(node.val);
        if (node.left != null) {
            result.append("(");
            treeToString(node.left, result);
            result.append(")");
        }
        if (node.right != null) {
            if (node.left == null) {
                result.append("()");
            }
            result.append("(");
            treeToString(node.right, result);
            result.append(")");
        }
    }
}

package BST正規二元樹;

import BinaryTree二元樹.TreeNode;

/**
 * 
 * 
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 * Explanation: Another accepted tree is:
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        while (cur != null) {
            // 如果輸入的值比cur 還要大就放到右邊
            if (cur.val < val) {
                if (cur.right != null) {
                    // 代表右邊還有值 繼續遍歷
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                // 如果輸入的值比cur 還要小就放到左邊
                if (cur.left != null) {
                    // 代表左邊還有值 繼續遍歷
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}

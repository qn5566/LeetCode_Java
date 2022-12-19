package BinaryTree二元樹;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 這題跟每一層平均很像
 * BFS 算法 左到右
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    res = cur.val;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }
}

/**
 * 或是直接遍例
 * 但把left擺最後
 * 這樣剛好可以直接返回left的ress
 */
class Solution_2 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }

}

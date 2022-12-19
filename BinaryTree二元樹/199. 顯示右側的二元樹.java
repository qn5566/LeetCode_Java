package BinaryTree二元樹;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * 
 * BFS 算法 從右到左
 * 我們改成從右加到左就好
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 抓第一個 也就是 index 0
            // 這也是ok 但不好解釋
            // res.add(queue.peek().val);

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                // 抓第一個 也就是 index 0
                if (i == 0) {
                    res.add(cur.val);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

            }
        }
        return res;
    }
}

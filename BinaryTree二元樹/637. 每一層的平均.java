package BinaryTree二元樹;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 一層一層計算 如果還有下一層 就先加入Queue裡面待計算
 * 
 * Time Complexity:
 * O(n)
 * Space Complexity:
 * O(h) 層數
 * 
 * Solution 1:
 * 
 * BFS
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                // 計算這一層的值
                TreeNode cur = queue.poll();
                sum += cur.val;

                // 準備下一層的值
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            res.add(sum / size);
        }
        return res;
    }
}

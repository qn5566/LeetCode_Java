package Google經典題目;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路
 * 使用广度优先搜索的方法，用一个队列 q 存储需要计算的节点。
 * 每次取出队首节点时，若节点为空则跳过该节点，否则按方法一中给出的大小关系来决定加入队列的子节点。
 * 
 * 时间复杂度：O(n)，其中 n 是二叉搜索树的节点数
 * 空间复杂度：O(n)。空间复杂度主要取决于队列的空间
 * 
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 */
class Solution {
    public int rangeSumBST(TreeNode root, int left, int right) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            if (node.val > right) {
                q.offer(node.left);
            } else if (node.val < left) {
                q.offer(node.right);
            } else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }

    /**
     * DST的寫法
     * 
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumDST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumDST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumDST(root.right, low, high);
        }
        return root.val + rangeSumDST(root.left, low, high) + rangeSumDST(root.right, low, high);
    }
}

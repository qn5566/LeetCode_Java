package BinaryTree二元樹;

/**
 * Time Complexity: O(n)
 * Space Complextiy: O(n)
 * 概念是對的，但應該要改成找出 所有節點的 left MaxDepth 及 所有節點的 right MaxDepth 相加最大值 才對
 * 
 * 因為會有這種奇怪情況，最長路徑不經過 root，所以要全部都掃過
 * 
 * 
 * 宣告一個全域變數 int max
 * 撰寫 MaxDepth method
 * 若 root 為 null，回傳 0
 * 用遞迴 Recursion 找出 left 節點的最大深度
 * 用遞迴 Recursion 找出 right 節點的最大深度
 * 比較 max 及 left 的最大深度 + right 的最大深度，並將較大的紀錄在 max
 * 這邊就是在紀錄除了root 外的最長路徑
 * 比較 left 的最大深度及 right 的最大深度，並將較大的值 + 1 後回傳
 * 此時的 +1 就是 往下多一階 的意思
 * 在主要 method DiameterOfBinaryTree 裡呼叫 MaxDepth，並回傳 max 即可
 * 因為直接回傳 MaxDepth 的話就是須經過 root 的最長路徑，但題目需求要的是整棵樹的最長路徑
 */
class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

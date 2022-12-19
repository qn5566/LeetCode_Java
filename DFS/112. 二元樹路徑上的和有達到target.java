package DFS;

/**
 * 題型解說
這是一題難度為簡單的題目

需要設計一個方法，此方法會傳入一個二元樹 root 和一個整數 sum

回傳這棵樹有沒有一條路徑的所有節點總和為 sum

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
 * 
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        int n = targetSum - root.val;
        
        if (root.left == null && root.right == null && n == 0) {
            return true;
        }
        
        return hasPathSum(root.left, n) || hasPathSum(root.right, n);
    }
}
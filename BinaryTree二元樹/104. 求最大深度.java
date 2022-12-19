package BinaryTree二元樹;

/**
 * Time Complexity: O(n)
 * 
 * Space Complextiy: O(1)
 * 這題其實沒有很難，只是要找出這顆樹的最大深度，所以只要遞迴寫好就好，就看你熟不熟悉 遞迴 了！！
 * 
 * 判斷 root 是否為 null，若是則回傳 0
 * 回傳此節點的深度
 * 遞迴找出 root 的right 右節點 最大深度
 * 遞迴找出 root 的left 左節點 最大深度
 * 比較兩個節點的最大深度，使用Math.Max 取 最大值
 * 最後並 +1，代表需要往上多加這一層
 * 
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
package BST正規二元樹;

import BinaryTree二元樹.TreeNode;

/**
 * 首先要知道，這是一棵二元搜尋樹，假設這個LCA的節點叫作L好了，
 * 兩個節點分別叫p跟q，那麼我們可以考慮以下幾個狀況：
 * 1. 如果L是p或q其中之一的話，先遇到誰，就代表誰是那個LCA。
 * (因為先遇到的節點會是後面的那個節點的祖先)
 * 2. 如果L不是p或q其中之一的話，L的値的範圍必在p.val和q.val之間，
 * 也就是說兩者會位在L的不同側的子樹。
 * (即p.val < L.val < q.val或p.val > L.val > q.val)
 * 
 * 如果從root開始判斷的話，就可以分成幾種情況：
 * 1. root的値和p或q的值相等 => 直接回傳root (p或q就是L)
 * 2. root的値在p和q的值的範圍之內 => 直接回傳root
 * (即p.val < L.val < q.val或p.val > L.val > q.val)
 * 3. p和q的値都小於root的值 => 往下找root.left的狀況遞迴
 * 4. p和q的値都大於root的值 => 往下找root.right的狀況遞迴
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;

    }
}
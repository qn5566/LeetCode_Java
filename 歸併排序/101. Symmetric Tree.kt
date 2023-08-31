
問題描述
給定一棵二叉樹，檢查它是否是對稱的。
如果一棵二叉樹在鏡像對稱下，則它是對稱的。
例如，下圖是對稱的二叉樹：

以下為一些範例：

範例 1:

vbnet
Copy code
Input: root = [1,2,2,3,4,4,3]
Output: true
範例 2:

yaml
Copy code
Input: root = [1,2,2,null,3,null,3]
Output: false
解法
這道題目需要判斷一棵二叉樹是否為鏡像對稱，所以可以使用遞歸來解決問題。
透過遞歸可以得到樹的左右子樹，然後將左子樹反轉，最後再和右子樹進行比較，如果相同，則代表這棵二叉樹是對稱的。
具體來說，先將樹的左右子樹分別取出來，然後遞歸比較兩個子樹是否對稱。具體實現方法可以參考下面的代碼。


class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return isMirror(root.left, root.right)
    }
    
    private fun isMirror(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        return (p.`val` == q.`val`) &&
                isMirror(p.left, q.right) &&
                isMirror(p.right, q.left)
    }
}

複雜度分析
時間複雜度：$O(n)$，其中 $n$ 是二叉樹的節點數。每個節點在递歸中只被遍歷一次。
空間複雜度：$O(n)$，其中 $n$ 是二叉樹的節點數。最壞情況下，需要遞歸 $n$ 層，因此空間複雜度為 $O(n)$。

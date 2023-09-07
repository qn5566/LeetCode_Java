这个问题是要求生成所有可能的二叉搜索树（BST），其中节点的值从1到n，且每个树的结构都是唯一的。
BST 是一种二叉树，其中左子树的所有节点的值都小于根节点的值，右子树的所有节点的值都大于根节点的值。

解决这个问题的关键是要理解 BST 的性质，以及如何递归地生成它们。下面是问题的解决思路：

1. 生成从1到n的每个数字作为根节点。假设当前选择的数字是i。
2. 递归地生成所有可能的左子树。这里的左子树是由1到i-1这些数字组成的BST。
3. 递归地生成所有可能的右子树。这里的右子树是由i+1到n这些数字组成的BST。
4. 将左子树和右子树与根节点i组合，形成一颗完整的BST。
5. 重复以上步骤，直到处理完所有数字为止。

在每一步中，我们都要生成子树，并将它们与当前的根节点组合起来，形成一个更大的BST。
最终，我们将获得所有可能的BST。
这个问题的解决方案可以通过递归来实现，其中递归函数 generateSubtrees(s, e) 生成由s到e这些数字组成的BST，
并返回一个列表，其中包含所有可能的BST的根节点。这个函数会根据给定的范围s到e，生成所有可能的左子树和右子树，并将它们与根节点组合在一起。
最终，调用 generateTrees(n) 函数即可生成所有可能的BST，其中n是给定的数字范围。

class Solution {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n < 1) {
            return emptyList()
        }
        return generateSubtrees(1, n)
    }

    private fun generateSubtrees(s: Int, e: Int): List<TreeNode?> {
        val res = mutableListOf<TreeNode?>()

        // 当 s > e 就直接给null，左边大于右边的时候也就是停止个时候了
        if (s > e) {
            res.add(null)
            return res
        }

        // i 的左半边为 s -> i-1
        // i 的右半边为 i+1 -> e
        // 中间为 i
        for (i in s..e) {
            val leftSubtrees = generateSubtrees(s, i - 1)
            val rightSubtrees = generateSubtrees(i + 1, e)
            for (left in leftSubtrees) {
                for (right in rightSubtrees) {
                    val root = TreeNode(i)
                    root.left = left
                    root.right = right
                    res.add(root)
                }
            }
        }
        return res
    }
}

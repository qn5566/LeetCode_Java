package Google經典題目;

import java.util.Stack;

/**
 * 解析：
每次 next 的时候把 stack 的头拿出来，如果这个节点有右子树的话，把右子树里的左边这条 path 全都给加到 stack 里面。（BST 节点的是顺序是这样的）
 */
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    TreeNode next = null;
    void AddNodeToStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    } 
    
    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        next = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        if (next != null) {
            AddNodeToStack(next);
            next = null;
        }
        return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        if (!hasNext()) {
            return null;
        }
        TreeNode cur = stack.pop();
        next = cur.right;
        return cur;
    }
}
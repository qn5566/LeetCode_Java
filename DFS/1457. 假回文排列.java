package DFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

import BinaryTree二元樹.TreeNode;

class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        HashSet<Integer> seen = new HashSet<>();
        return helper(root, seen);
        
    }
    public int helper(TreeNode node, HashSet<Integer> set){
        if(node == null) return 0;
        if(set.contains(node.val)) set.remove(node.val);
        else set.add(node.val);
        if(node.left==null && node.right == null){
            if(set.size()<=1) return 1;
            else return 0;
        }
        
        return helper(node.left,(HashSet<Integer>)set.clone())+helper(node.right,(HashSet<Integer>)set.clone());
    }
}

class Solution_2 {
    public int pseudoPalindromicPaths (TreeNode root) {
        int count = 0, path = 0;
        
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            path = p.getValue();

            if (node != null) {
                // compute occurences of each digit 
                // in the corresponding register
                path = path ^ (1 << node.val);
                // if it's a leaf check if the path is pseudo-palindromic
                if (node.left == null && node.right == null) {
                    // check if at most one digit has an odd frequency
                    if ((path & (path - 1)) == 0) {
                        ++count;
                    }
                } else {
                    stack.push(new Pair(node.right, path));
                    stack.push(new Pair(node.left, path));
                }
            }
        }
        return count;
    }
}
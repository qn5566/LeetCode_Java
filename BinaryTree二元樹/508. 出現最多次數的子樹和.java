package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
class Solution {
    //
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        postOrder(root);

        List<Integer> ans = new ArrayList<>();
        for (Integer num : map.keySet()) {
            if (map.get(num) == maxFreq) {
                ans.add(num);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = postOrder(root.left);
        int rightSum = postOrder(root.right);

        int val = root.val + leftSum + rightSum;

        map.put(val, map.getOrDefault(val, 0) + 1);
        maxFreq = Math.max(maxFreq, map.get(val));

        return val;
    }
}
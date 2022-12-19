package BST正規二元樹;

import java.util.ArrayList;
import java.util.List;

import BinaryTree二元樹.TreeNode;

/**
 * BST 有一個規則是說 從小排到大
 * 所以我們可以只要跟下一個val比較好
 * 有的話就加curCnt
 * 沒有的話就清除換下一個
 * 
 * 我們可以用兩個值儲存記錄
 * 一個是現在出現次數的值
 * 一個是出現次數最高的值
 * 當出現次數高於最高次數的時候
 * 在更新List的數據
 * 
 * 
 * Input: root = [1,null,2,2]
 * Output: [2]
 */
class Solution {
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null)
            return;
        inOrder(node.left, nums);

        // 判斷preNode 是不是第一組
        if (preNode != null) {
            // 判斷有沒有一樣
            if (preNode.val == node.val)
                curCnt++;
            else
                curCnt = 1;
        }

        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            // 先加進去
            nums.add(node.val);
        }

        preNode = node;
        inOrder(node.right, nums);
    }
}
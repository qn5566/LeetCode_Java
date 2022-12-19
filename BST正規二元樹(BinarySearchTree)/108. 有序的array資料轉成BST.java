package BST正規二元樹;

import BinaryTree二元樹.TreeNode;

/**
 * 從中間分兩半
 * 中間 mIdx
 * 
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int sIdx, int eIdx) {
        if (sIdx > eIdx) {
            return null;
        }

        int mIdx = (sIdx + eIdx) / 2;
        TreeNode root = new TreeNode(nums[mIdx]);

        // 左邊到中間
        root.left = toBST(nums, sIdx, mIdx - 1);

        // 中間到右邊
        root.right = toBST(nums, mIdx + 1, eIdx);
        return root;
    }
}

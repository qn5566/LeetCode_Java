package 快速排序;

/**
 * 题目描述：只有 0/1/2 三种颜色。
 * 
 * 
 */
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        // 從-1 開始 到 尾巴後面 中間是 1
        int left = -1, right = nums.length;
        int i = 0;
        while (i < right) {
            if (nums[i] == 1) {
                // 等於1就放到中間去 所以i++
                i++;
            } else if (nums[i] == 2) {
                // 等於2就放到後面去而且不確定換過來的是不是0所以i沒有動
                right--;
                swap(nums, i, right);
            } else {
                // 等於0就直接放到後面去
                left++;
                swap(nums, i, left);
                i++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

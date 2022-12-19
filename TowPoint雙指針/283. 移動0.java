package TowPoint雙指針;

/**
 * For example, given nums = [0, 1, 0, 3, 12],
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * 題目要求不能配置新的空間，必須在原本陣列做修改勢必複雜度不超過 O(n)。
 * 
 * 陣列走訪
 * Run Time: 3 ms
 * 時間複雜度: O(n)
 * 空間複雜度: O(1)
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int fast = 0, slow;
        for (slow = 0; fast < nums.length; fast++) {
            // 當nums[fast] 不是0的時候一起動
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }

        // 剩下再補0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

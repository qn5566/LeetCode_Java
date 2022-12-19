package TowPoint雙指針;

/**
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * 
 * 分析/解題：
 * 題目要求將一個已排序陣列中所有的重複數字刪去，
 * 使得這個陣列的每個數字只出現一次，並且必須要以in-place的方式來處理。
 * 最終處理過後，回傳新陣列的長度。
 * 
 * 同向雙指針
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            // if not duplicate, keep it, otherwise skip it.
            if (slow == 0 || nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        return slow;
    }
}
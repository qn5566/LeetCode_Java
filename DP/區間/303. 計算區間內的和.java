package DP.區間;

/**
 * 給一個int陣列，寫一個sumRange方法找尋陣列中元素i~j的總和。
 * 範例： nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3
 * 
 * 注意：你不能改變傳入陣列的值，然後sumRange會被忽叫很多次。
 * 先定義一個class把算式加進去
 * 
 * 時間複雜度 O(n) + m * O(1) = O(n+m)
 * 空間複雜度 O(n)
 * 
 * 一開始的想法是sumRange被忽叫時就跑迴圈把i到j之間全部的值加起來，這很簡單，不過果然超時(TLE)了
 * 換個想法，sumRange會被忽叫很多次，因此在裡面寫迴圈不是一個好辦法
 * 這邊先用另外一個array來儲存a[0]~a[i]的加總，之後要取加總只要取array[j]-array[i-1]就可以
 * 以 [-2, 0, 3, -5, 2, -1] 為例，array = [-2,-2,1,-4,2,1]
 * sumRange(0, 2) --> i = 0，因此只要直接取array[j] = 2
 * sumRange(2, 5) --> 取array[5] = -1，array[1] = 0， sum = array[j]-array[i-1] =
 * -1
 */
class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}

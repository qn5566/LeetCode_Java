package 二分查找binarySearch;

import java.util.Arrays;

/**
 * ex1 :
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in
 * 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * 
 * Note that the cargo must be shipped in the order given, so using a ship of
 * capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6,
 * 7), (8), (9), (10) is not allowed.
 * 
 * ex2:
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in
 * 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * 
 * ex3:
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * 
 * 上述代碼中，我們使用Java的內置函數 max() 和 sum() 分別獲取數組中的最大值和總和。在二分查找過程中，我們使用 while
 * 循環來尋找船舶負載能力的最小值，計算需要的天數時，我們使用 for 循環來遍歷 weights 數組，並使用 cur
 * 變量來表示當前船舶的負載量，如果負載量超過了 mid，我們需要開始新的一天，需要的天數 need 加1，並將 cur
 * 重置為0。最後，我們根據需要的天數和給定的天數 D 來更新船舶負載能力的最小值和最大值，直到找到最小的船舶負載能力。
 */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // 船舶負載能力的最小值和最大值
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        // 二分查找
        while (left < right) {
            int mid = (left + right) / 2;
            // 計算需要的天數
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

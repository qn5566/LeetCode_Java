package 綜合;

import java.util.LinkedList;
import java.util.List;

/**
 * ex1:
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * 
 * ex2:
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * 
 * ex3:
 * Input: num = [2,1,5], k = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * 
 * 
 */
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new LinkedList<>();

        // 如果k=0就沒有了
        // 先結算尾數
        for (int i = num.length - 1; i >= 0 || k > 0; i--) {
            int sum = k;
            if (i >= 0)
                sum += num[i];

            // 先結算尾數
            ans.add(0, sum % 10);
            k = sum / 10;
        }

        return ans;
    }
}
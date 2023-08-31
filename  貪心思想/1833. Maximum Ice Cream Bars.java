import java.util.Arrays;

/**
 * 吃冰的問題
 * 
 * Input: costs = [1,3,2,4,1], coins = 7
 * Output: 4
 * Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total
 * price of 1 + 3 + 2 + 1 = 7.
 * 
 * Input: costs = [10,6,8,7,7,8], coins = 5
 * Output: 0
 * Explanation: The boy cannot afford any of the ice cream bars.
 * 
 * Input: costs = [1,6,3,1,2,5], coins = 20
 * Output: 6
 * Explanation: The boy can buy all the ice cream bars for a total price of 1 +
 * 6 + 3 + 1 + 2 + 5 = 18.
 */
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        if (costs.length == 0)
            return 0;
        Arrays.sort(costs);

        int ans = 0;
        for (int i = 0; i < costs.length && coins >= 0; i++) {
            coins -= costs[i];
            ans++;
        }

        if (coins < 0) {
            ans--;
        }

        return ans;
    }
}

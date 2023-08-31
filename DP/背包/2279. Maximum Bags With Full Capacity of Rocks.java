package DP.背包;

import java.util.Arrays;

/**
 * 
 * EX 1 :
 * Input: capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
 * Output: 3
 * Explanation:
 * Place 1 rock in bag 0 and 1 rock in bag 1.
 * The number of rocks in each bag are now [2,3,4,4].
 * Bags 0, 1, and 2 have full capacity.
 * There are 3 bags at full capacity, so we return 3.
 * It can be shown that it is not possible to have more than 3 bags at full
 * capacity.
 * Note that there may be other ways of placing the rocks that result in an
 * answer of 3.
 * 
 * 
 * Ex 2:
 * Input: capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
 * Output: 3
 * Explanation:
 * Place 8 rocks in bag 0 and 2 rocks in bag 2.
 * The number of rocks in each bag are now [10,2,2].
 * Bags 0, 1, and 2 have full capacity.
 * There are 3 bags at full capacity, so we return 3.
 * It can be shown that it is not possible to have more than 3 bags at full
 * capacity.
 * Note that we did not use all of the additional rocks.
 * 
 * additionalRocks 的石頭放滿capacity
 * 求最多可以幾個全滿
 */
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff = new int[capacity.length];
        // 包包的空格
        long cnt = 0;

        // 累加有幾個包包滿
        int resCnt = 0;

        for (int i = 0; i < capacity.length; i++) {
            int diffCnt = capacity[i] - rocks[i];

            diff[i] = diffCnt;
            cnt += (long) diffCnt;
        }

        if ((long) additionalRocks > cnt) {
            return capacity.length;
        }

        Arrays.sort(diff);

        for (int a : diff) {
            if (a == 0) {
                resCnt += 1;
                continue;
            }

            if (additionalRocks >= a) {
                resCnt += 1;
                additionalRocks -= a;
            } else {
                return resCnt;
            }
        }

        return resCnt;
    }
}

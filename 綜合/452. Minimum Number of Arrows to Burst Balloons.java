package 綜合;

import java.util.Arrays;

/**
 * ex 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * 
 * ex 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4
 * arrows.
 * 
 * ex 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * 
 * 尋找重疊的焦點
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        // sort the elements based on the second element
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        // lets have a varible for storing the result
        int arrowCount = 0;
        long possibleEnd = Long.MIN_VALUE;
        for (int[] p : points) {
            if (p[0] > possibleEnd) {
                possibleEnd = p[1];
                arrowCount += 1;
            }
        }
        return arrowCount;
    }
}
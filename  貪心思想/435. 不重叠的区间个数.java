import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，
 * 那么后面能够选择的区间个数也就越大。
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 * 
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are
 * non-overlapping.
 * 
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals
 * non-overlapping.
 * 
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 先排序好確保小到大
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        // 統計不重複的區間 - 初始值是自己
        int cnt = 1;

        // 抓end的點 跟其他區間的start點做比較
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果比較小就可以跳過
            if (intervals[i][0] < end) {
                continue;
            }

            // 替換end的點
            end = intervals[i][1];
            cnt++;
        }

        // 所有的數量減掉不重複的區間，可以得知重複數量
        return intervals.length - cnt;
    }
}

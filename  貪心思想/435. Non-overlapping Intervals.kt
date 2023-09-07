"435. Non-overlapping Intervals" 是一个区间调度问题，要求从给定的区间列表中移除最少数量的区间，使得剩余的区间不重叠。


class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) {
            return 0
        }
        
        // 按照区间的结束时间进行排序
        intervals.sortBy { it[1] }
        
        var count = 1  // 记录非重叠区间数量
        var end = intervals[0][1]  // 记录当前最后一个区间的结束时间
        
        for (i in 1 until intervals.size) {
            // 如果下一个区间的开始时间大于等于当前最后一个区间的结束时间，表示不重叠
            if (intervals[i][0] >= end) {
                count++
                end = intervals[i][1]
            }
        }
        
        // 需要移除的区间数量为总区间数量减去非重叠区间数量
        return intervals.size - count
    }
}

这个代码使用贪心算法的思想来解决问题。首先，将区间按照结束时间进行排序。
然后，从第一个区间开始，遍历每个区间，判断是否与前一个区间重叠。
如果下一个区间的开始时间大于等于当前最后一个区间的结束时间，表示它们不重叠，可以保留。否则，需要移除一个区间以保证不重叠。
在这个过程中，我们通过比较区间的结束时间来选择保留哪些区间，以确保剩余的区间数量最大。
最后，需要移除的区间数量即为总区间数量减去保留的非重叠区间数量。
这个算法的时间复杂度为 O(nlogn)，其中 n 是区间的数量，因为需要对区间进行排序。这是一个经典的区间调度问题的解决方案。
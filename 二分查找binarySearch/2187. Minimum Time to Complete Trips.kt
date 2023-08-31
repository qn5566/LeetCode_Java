

/**
 * 给定一个长度为 n 的正整数数组 time，表示每个公交车完成一次旅途所需要的时间。现有 m 辆公交车和一个容量无限的公共汽车站。
 * 第 i 辆公交车会在时刻 0 开始运行，第 i 辆公交车可以无限次提供服务。已知第 i 辆公交车在 t 时刻提供服务将会结束，其中 t 严格大于时刻 0 且由你确定。
 * 你需要在恰好 m 辆公交车结束服务时完成 n 次旅行。你将会在一开始时有一个空站点。每一次乘坐公交车从空站点开始。公交车在结束服务后会返回空站点。
 * 求完成所有旅行所需的最小天数。如果无法完成所有旅行，返回 -1 。
 * 解题思路：
 * 题目要求在恰好 m 辆公交车结束服务时完成 n 次旅行，即需要求出一个最小时间，使得 m 辆公交车服务次数之和等于 n。
 * 显然，所求的最小时间 t 的范围在 [0, min(time)*n] 内，因为公交车运行的总时间不会小于最快的一辆公交车乘坐 n 次。
 * 可以用二分查找的思路，对 t 进行二分查找。在每次二分中，根据当前的 t 计算出当前所有公交车的服务次数之和 trips，如果 trips >= n，
 * 则说明当前时间 t 能满足所有旅行次数，将右边界 right 赋值为 mid；否则，将左边界 left 赋值为 mid+1。
 * 时间复杂度为 O(n log t)，其中 t 为最小时间的范围，即 O(n log min(time)*n)。
 * 
 * Input: time = [1,2,3], totalTrips = 5
Output: 3
Explanation:
- At time t = 1, the number of trips completed by each bus are [1,0,0]. 
  The total number of trips completed is 1 + 0 + 0 = 1.
- At time t = 2, the number of trips completed by each bus are [2,1,0]. 
  The total number of trips completed is 2 + 1 + 0 = 3.
- At time t = 3, the number of trips completed by each bus are [3,1,1]. 
  The total number of trips completed is 3 + 1 + 1 = 5.
So the minimum time needed for all buses to complete at least 5 trips is 3.
 */


class Solution {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        time.sort()
        var left = 0L
        var right = time[0].toLong() * totalTrips

        while (left < right) {
            val mid = left + (right - left) / 2
            // 计算mid时间内能跑的趟数
            var trips = 0L
            for (i in time) {
                if (i > mid){
                    break
                }
                    trips += mid / i
            }
            // 即旅途数可以减小
            if (trips >= totalTrips) right = mid
            // 时间不够旅途数
            else left = mid + 1
        }
        return left
    }
}
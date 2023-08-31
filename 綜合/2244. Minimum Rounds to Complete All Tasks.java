package 綜合;

import java.util.HashMap;

/**
 * ex :
 * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
 * Output: 4
 * Explanation: To complete all the tasks, a possible plan is:
 * - In the first round, you complete 3 tasks of difficulty level 2.
 * - In the second round, you complete 2 tasks of difficulty level 3.
 * - In the third round, you complete 3 tasks of difficulty level 4.
 * - In the fourth round, you complete 2 tasks of difficulty level 4.
 * It can be shown that all the tasks cannot be completed in fewer than 4
 * rounds, so the answer is 4.
 * 
 * 完成所有任务需要的最少轮数。
 * 
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别
 * 的任务。
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 思路是计数排序 + 贪心。首先我们需要用 hashmap 统计每个不同元素分别出现了几次（value），然后我们需要判断每个元素对应的 value
 * 是否能被 2 或者 3 整除。分如下几种情况，
 * 
 * value == 1，这个任务无法被完成，直接返回 -1
 * value == 2 和 value == 3，轮数 += 1
 * value % 3 == 0，轮数 += value / 3
 * value % 3 == 1，轮数 += value / 3 + 1
 * value % 3 == 2，轮数 += value / 3 + 1
 * 这里需要解释一下最后两种情况的轮数
 * 
 * 如果一个数字 % 3 == 1，设这个数字 = 3m + 1，3m + 1 = 3m + 3 - 2 = 3(m + 1) - 2，所以这个数字需要被 %
 * 3若干次之后再被 % 2一次，即可被处理完
 * 
 * 如果一个数字 % 3 == 2，设这个数字 = 3m + 2，这个数字需要被 % 3若干次之后再被 % 2一次，即可被处理完，次数同上一种情况
 * 
 * 时间O(n)
 * 
 * 空间O(n)
 */
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        int count = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value == 1) {
                return -1;
            } else if (value == 2) {
                count += 1;
            } else if (value % 3 == 0) {
                count += value / 3;
            } else {
                count += value / 3 + 1;
            }
        }
        return count;
    }
}

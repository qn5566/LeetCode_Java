package 綜合;

/**
 * 
 * Input: A = ["cba","daf","ghi"]
 * Output: 1
 * Explanation:
 * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in
 * non-decreasing sorted order.
 * If we chose D = {}, then a column ["b","a","h"] would not be in
 * non-decreasing sorted order.
 * 
 * 这个题目也比较直接，就是看现在的字符串在每个index上有多少个是不符合排序规则的。
 * 因为整个数组都要求在某一个index上排序，所以每次只需要和前一个比较就好
 * 
 * 时间复杂度
 * 两层循环，O(N*M), 其中N是数组的长度， M是数组每个字符串的长度
 * 
 * 空间复杂度
 * 只使用了一个常量， O(1)
 */
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

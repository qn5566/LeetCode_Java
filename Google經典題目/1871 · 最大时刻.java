package Google經典題目;

/**
 * 解法：贪心
 * 算法：贪心
 * 解题思路
 * 直接对于问号处的数字变成最大，要判断是否满足时间的标准。
 * 
 * 复杂度分析
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
class Solution {
    /**
     * @param time: a string of Time
     * @return: The MaximumMoment
     */
    public String MaximumMoment(String time) {

        char[] timeChars = time.toCharArray();
        if (timeChars[0] == '?') {
            if (timeChars[1] <= '9' && timeChars[1] >= '4')
                timeChars[0] = '1';
            else
                timeChars[0] = '2';
        }

        if (timeChars[1] == '?') {
            if (timeChars[0] != '2')
                timeChars[1] = '9';
            else
                timeChars[1] = '3';
        }
        if (timeChars[3] == '?')
            timeChars[3] = '5';
        if (timeChars[4] == '?')
            timeChars[4] = '9';

        return String.valueOf(timeChars);
    }
}

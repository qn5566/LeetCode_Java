package 綜合;

/**
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * 
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * 
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 * 
 * 只能換一次6換9
 * 求最大值
 * 
 */
class Solution {
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '6') {
                String ret = s.substring(0, i) + '9' + s.substring(i + 1);
                return Integer.valueOf(ret);
            }
        }
        return num;
    }
}

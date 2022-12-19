package 綜合;

/**
 * 數字變成羅馬文字
 * 
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * 
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * 
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
class Solution {
    public String intToRoman(int num) {
        String result = "";
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result += romans[i];
            }
        }
        return result;
    }
}
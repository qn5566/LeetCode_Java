package 綜合;

/**
 * ex1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * 
 * ex2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * 
 * ex3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * 
 * 此題特性是因為需要可以相除
 * 所以從前面開始算就是要一樣
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int maxLen = Math.min(len1, len2);

        for (int i = maxLen; i >= 1; i--) {
            // 先判斷文字是否相等
            if (len1 % i == 0 && len2 % i == 0 && str1.substring(0, i).equals(str2.substring(0, i))) {
                // 延長公因數文字
                String tmp1 = str1.substring(i) + str1.substring(0, i);
                String tmp2 = str2.substring(i) + str2.substring(0, i);
                
                if (tmp1.equals(str1) && tmp2.equals(str2)) {
                    // 確認一樣之後返回
                    return str1.substring(0, i);
                }
            }
        }

        return "";
    }
}

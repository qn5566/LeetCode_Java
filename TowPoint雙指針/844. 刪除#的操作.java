package TowPoint雙指針;

/**
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * 
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * 
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * 
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * 这道题给了我们两个字符串，里面可能会有井号符#，这个表示退格符，
 * 键盘上的退格键我们应该都很熟悉吧，当字打错了的时候，肯定要点退格键来删除的。
 * 当然也可以连续点好几下退格键，这样就可以连续删除了，
 * 在例子2和3中，也确实能看到连续的井号符。题目搞懂了之后，就开始解题吧，
 * 
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        // 先統計一下這兩個文字的總數 i, j
        int i = S.length() - 1, j = T.length() - 1;
        // 計算分別有幾個#字符
        int skipS = 0, skipT = 0;

        // 當還有字串的時候繼續檢查
        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)

            while (i >= 0) { // Find position of next possible char in build(S)
                // 有#的話記錄
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else
                    break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else
                    break;
            }

            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }
}
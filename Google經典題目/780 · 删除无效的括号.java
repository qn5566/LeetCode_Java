package Google經典題目;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路
 * 有效的「括号」：题目输入的字符串由一系列「左括号」和「右括号」组成，但是有一些额外的括号，使得括号不能正确配对。
 * 
 * 可以一次遍历计算出多余的「左括号」和「右括号」，如果当前遍历到的「左括号」的数目严格小于「右括号」的数目则表达式无效。因此，我们可以遍历一次输入字符串，统计「左括号」和「右括号」出现的次数。
 * 
 * 当遍历到「左括号」的时候：
 * 「左括号」数量加 11。
 * 当遍历到「右括号」的时候：
 * 如果此时「左括号」的数量不为 00，因为「右括号」可以与之前遍历到的「左括号」匹配，此时「左括号」出现的次数 -1−1；
 * 如果此时「左括号」的数量为 00，「右括号」数量加 11。
 * 通过这样的计数规则，得到的「左括号」和「右括号」的数量就是各自最少应该删除的数量。
 */
class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     *          we will sort your return value in output
     */
    private List<String> res = new ArrayList<String>();

    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        int lremove = 0;
        int rremove = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove == 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }
        helper(s, 0, lremove, rremove);

        return res;
    }

    private void helper(String str, int start, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                res.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            // 如果剩余的字符无法满足去掉的数量要求，直接返回
            if (lremove + rremove > str.length() - i) {
                return;
            }
            // 尝试去掉一个左括号
            if (lremove > 0 && str.charAt(i) == '(') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
            }
            // 尝试去掉一个右括号
            if (rremove > 0 && str.charAt(i) == ')') {
                helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
            }
        }
    }

    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }

}
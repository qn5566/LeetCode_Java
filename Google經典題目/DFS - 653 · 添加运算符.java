package Google經典題目;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * @param num:    a string contains only digits 0-9
     * @param target: An integer
     * @return: return all possibilities
     */
    // 思路：暴搜所有的表达式，计算表达式结果，等于target的是结果
    // 字符串长度为len, 一共有len - 1个位置，每个位置有四种可能: 不插入符号, + , - , *
    // 搜索的复杂度O(4 ^ (n - 1))
    // value记录当前表达式计算的结果， prev计算上一次计算的结果prevVal
    /*
     * 当前添加符号时有以下可能：
     * +
     * -
     *
     * 
     * 
     * 1 + 2 * 3
     * 
     * 1
     * 3
     * 
     * 9
     * 
     * 
     * 
     * corner case: 零不能作为数字的开头, 1(+-*不插) 0(+-*) 5
     * + - 不能作为一元运算符(aka 不能出现在表达式的头部)
     */

    public List<String> addOperators(String num, int target) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, "", 0, 0, ans);
        return ans;
    }

    void dfs(String num, int target, int start, String str, long sum, long lastF, List<String> ans) {
        if (start == num.length()) {
            if (sum == target) {
                ans.add(str);
            }
            return;
        }
        for (int i = start; i < num.length(); i++) {
            long x = Long.parseLong(num.substring(start, i + 1));

            if (start == 0) {
                dfs(num, target, i + 1, "" + x, x, x, ans);
            } else {
                dfs(num, target, i + 1, str + "*" + x, sum - lastF + lastF * x, lastF * x, ans);
                dfs(num, target, i + 1, str + "+" + x, sum + x, x, ans);
                dfs(num, target, i + 1, str + "-" + x, sum - x, -x, ans);
            }
            if (x == 0) {
                break;
            }
        }
    }
}
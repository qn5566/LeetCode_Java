package 綜合;

import java.util.LinkedList;

/**
 * 移除字符串中所有相邻的重复字符
 * 
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move. The result of this move is
 * that the string is "aaca", of which only "aa" is possible, so the final
 * string is "ca".
 */
class Solution {
    public String removeDuplicates(String S) {
        LinkedList<Character> list = new LinkedList<>();
        char[] arr = S.toCharArray();
        for (char c : arr) {
            if (!list.isEmpty() && list.getLast() == c) {
                list.removeLast();
            } else {
                list.addLast(c);
            }
        }
        if (list.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        while (list.size() != 0)
            sb.append(list.removeFirst());
        return sb.toString();
    }
}

class Solution2 {
    public String removeDuplicates(String S) {
       LinkedList<Character> list = new LinkedList<>();
char[] arr = S.toCharArray();

        return sb.toString();
    }
}
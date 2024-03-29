package TowPoint雙指針;

import java.util.List;

/**
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
 * 找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
 * 
 * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，
 * 我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 * 
 * longestWord.compareTo(target)
 * 左邊字元比較大是正的
 * ex:下面這種情況時沒有加的時候會發生
 * "abce"
 * ["abe","abc"]
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    // 兩個字元互相比對
    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            // 如果兩個字元的j數量等於target就代表裡面有字元可以相等
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    private boolean isSubstr_2(String s, String target){
        int i = 0 , j = 0;
        while(i < s.length() && j < target.length()){
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
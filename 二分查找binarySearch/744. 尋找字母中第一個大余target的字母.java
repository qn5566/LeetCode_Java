package 二分查找binarySearch;

/**
 * 让我们求字母数组中第一个大于target的字母，数组是循环的，如果没有，那就返回第一个字母
 * 
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * 
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * 
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
}

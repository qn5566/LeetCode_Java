package TowPoint雙指針;

/**
 * 將一個字串反轉後回傳。
 * 
 * 範例： s= "hello", return "olleh"
 * 
 * 經典反向雙指針
 * 
 * 直接用雙指針頭尾交換
 * 這樣時間只要 一半
 */
class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;

            l++;
            r--;
        }
    }
}
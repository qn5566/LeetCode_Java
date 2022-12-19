package 二分查找binarySearch;

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 * 
 *         已知 GuessGame 的 guess
 * 
 *         Input: n = 10, pick = 6
 *         Output: 6
 * 
 *         Input: n = 1, pick = 1
 *         Output: 1
 * 
 *         Input: n = 2, pick = 1
 *         Output: 1
 */

class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= n) {
            int mid = left + (right - left) / 2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
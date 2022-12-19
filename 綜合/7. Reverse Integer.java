package 綜合;

/**
 * 反轉的int
 * 
 * ex1 :
 * Input: x = 123
 * Output: 321
 * 
 * ex2:
 * Input: x = -123
 * Output: -321
 * 
 * ex3:
 * Input: x = 120
 * Output: 21
 */
class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        // 如果是負數先轉正
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        long reverse = 0;

        while (x > 0) {
            reverse = reverse * 10 + x % 10; // 剩餘余數

            x /= 10; // 因為x = int 所以小數點會變成0
        }

        // 防止0當分子過大
        if (reverse > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (isNegative ? -reverse : reverse);
    }
}

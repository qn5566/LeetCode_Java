package 綜合;

/**
 * 只要是1,2,3,5 都是髒數
 * 算法可以利用相除是否有餘數做判斷
 * 
 */
class Solution {
    public boolean isUgly(int num) {

        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }
            if (num % 3 == 0) {
                num = num / 3;
                continue;
            }
            if (num % 5 == 0) {
                num = num / 5;
                continue;
            }
            return false;
        }
        return true;
    }
}

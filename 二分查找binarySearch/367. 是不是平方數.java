package 二分查找binarySearch;

class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1, end = num;
        long mid;
        long midsquare;

        mid = start + (end - start) / 2;
        while (start <= end) {
            midsquare = mid * mid;

            if (midsquare == num) {
                return true;
            }
            if (midsquare < num) {
                start = (int) mid + 1;
            } else {
                end = (int) mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return false;
    }
}

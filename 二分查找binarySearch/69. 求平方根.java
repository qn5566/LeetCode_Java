package 二分查找binarySearch;

/**
 * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，
 * 并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
 * 
 * 对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。
 * 在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，
 * 也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
 */
// 新的方法
class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 1, right = x;
        while (left <= right) { // right 可能也是答案
            int mid = left + (right - left) / 2;
            if (mid > x / mid) { // 原本是 (mid*mid) > x 但是 mid*mid 可能數字會太大
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
// class Solution {
// public int mySqrt(int x) {
// if (x <= 1)
// return x;
// int left = 0, right = x;
// while (left < right) {
// int mid = (right + left) / 2;
// if (x / mid >= mid) {
// left = mid + 1;
// } else {
// right = mid;
// }
// }
// return right - 1;
// }
// }

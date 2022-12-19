package 綜合;

/**
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 =
 * 2
 * Output: 45
 * 
 * Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2
 * = 2
 * Output: 16
 * 
 * 解題重點 :
 * 取左側點的最小值和右側點的最大值
 * 相成就是他們的集合面積
 * 
 */
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (ax2 <= bx1 || ay1 >= by2 || ax1 >= bx2 || ay2 <= by1) {
            return total;
        }
        // if has overlap
        int a = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int b = Math.min(ay2, by2) - Math.max(ay1, by1);
        int dup = a * b;
        return total - dup;
    }
}

package 二分查找binarySearch;

/**
 * 搜尋二維矩正有沒有值
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * 
 * 把二維變成一維
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // mid / n 代表行 % n 代表列
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}

class Solution_old {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) {
            return false;
        }
        int left = 0, right = matrix.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int tmp = (right > 0) ? (right - 1) : right;
        left = 0;
        right = matrix[tmp].length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[tmp][mid] == target) {
                return true;
            }
            if (matrix[tmp][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
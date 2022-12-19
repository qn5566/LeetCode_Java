package 二分查找binarySearch;

/**
 * 求最大面積
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * 
 * Input: height = [1,1]
 * Output: 1
 * 
 * 理解 
 * 用二分法搜尋
 * 尋找兩個最小的高
 * 乘上他們之間的index
 * 就可以算上他們的面積
 * 在用 max 統計最大值
 */

class Solution {
    public int maxArea(int[] height) {
        // Maximum area will be stored in this variable
        int maximumArea = Integer.MIN_VALUE;
        // Left and right pointers
        int left = 0;
        int right = height.length - 1;
        // Loop until left and right meet
        while (left < right) {
            // Shorter pole/vertical line
            int shorterLine = Math.min(height[left], height[right]);
            // Update maximum area if required
            maximumArea = Math.max(maximumArea, shorterLine * (right - left));
            // If there is a longer vertical line present
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximumArea;
    }

}
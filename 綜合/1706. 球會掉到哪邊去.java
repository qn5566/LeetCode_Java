package 綜合;

/**
 * Input: grid =
 * [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * Output: [1,-1,-1,-1,-1]
 * Explanation: This example is shown in the photo.
 * Ball b0 is dropped at column 0 and falls out of the box at column 1.
 * Ball b1 is dropped at column 1 and will get stuck in the box between column 2
 * and 3 and row 1.
 * Ball b2 is dropped at column 2 and will get stuck on the box between column 2
 * and 3 and row 0.
 * Ball b3 is dropped at column 3 and will get stuck on the box between column 2
 * and 3 and row 0.
 * Ball b4 is dropped at column 4 and will get stuck on the box between column 2
 * and 3 and row 1.
 * 
 * 
 * 利用DFS 計算邊界
 */
class Solution {
    int rows, cols;

    public int[] findBall(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        int[] res = new int[cols];
        for (int i = 0; i < cols; i++) {
            res[i] = helper(i, grid);
        }
        return res;
    }

    private int helper(int n, int[][] grid) {
        int r = 0;
        int c = n;
        while (r < rows) {
            int nextC = c + grid[r][c];
            if (nextC < 0 || nextC > cols - 1 || grid[r][c] != grid[r][nextC]) {
                return -1;
            }
            r++;
            c = nextC;
        }
        return c;
    }
}

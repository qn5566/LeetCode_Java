package 搜尋.DFSIsLand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the following 5x5 matrix:
 * 
 * Pacific
 * ~ ~ ~ ~ ~ ~ ~ ~
 * ~ 1 2 2 3 (5) *
 * ~ 3 2 3 (4) (4) *
 * ~ 2 4 (5) 3 1 *
 * ~ (6) (7) 1 4 5 *
 * ~ (5) 1 1 2 4 *
 * -- * * * *
 * Atlantic
 * 
 * Return:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 * 左边和上边是太平洋，右边和下边是大西洋，内部的数字代表海拔，
 * 海拔高的地方的水能够流到低的地方，求解水能够流到太平洋和大西洋的所有位置。
 * 
 * 做2個數列 可以存從中間到左右兩邊的資料
 * canReachP
 * canReachA
 */
class Solution {
    private int m, n;
    private int[][] matrix;
    private int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        // 首先定義 可以到達p的點
        // 再來定義 可以到達A的點
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }

        return ret;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            // matrix[r][c] > matrix[nextR][nextC] 這裡說明你的值要比下一步還要大才行
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] > matrix[nextR][nextC]) {

                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }
}

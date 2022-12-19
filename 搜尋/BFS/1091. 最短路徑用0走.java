package 搜尋.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有0才可以走
 * 
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * 
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * 
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 * 
 * * 使用 BFS
 */
class Solution {
    public int shortestPathBinaryMatrix(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = { { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int m = grids.length, n = grids[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                int[] point = queue.poll();
                int cr = point[0], cc = point[1];
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grids[cr][cc] = 1; // 标记

                // 找出可以走的路
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new int[] { nr, nc });
                }
            }
        }
        return -1;
    }

}

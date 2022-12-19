package Google經典題目;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 对于二维网格中的最短路问题，我们一般可以使用广度优先搜索 + 队列的方法解决。
 * 
 * 本题中，玩家在移动时可以消除障碍物，这会导致网格的结构发生变化，
 * 看起来我们需要在广度优先搜索时额外存储网格的变化。但实际上，由于玩家在最短路中显然不会经过同一位置超过一次，
 * 因此最多消除k 个障碍物等价于最多经过 k 个障碍物。
 * 
 * 这样我们就可以使用三元组 (x, y, rest) 表示一个搜索状态，其中 (x, y) 表示玩家的位置，
 * rest 表示玩家还可以经过 rest个障碍物，它的值必须为非负整数。
 * 对于当前的状态 (x, y, rest)，它可以向最多四个新状态进行搜索，即将玩家 (x, y)
 * 向四个方向移动一格。假设移动的方向为 (dx, dy)，
 * 那么玩家的新位置为 (mx + dx, my + dy)。如果该位置为障碍物，那么新的状态为
 * (mx + dx, my + dy, rest - 1)，否则新的状态为 (mx + dx, my + dy, rest)。
 * 我们从初始状态 (0, 0, k) 开始搜索，当我们第一次到达状态 (m - 1, n - 1, k')，
 * 其中 k' 是任意非负整数时，就得到了从左上角 (0, 0) 到右下角 (m - 1, n - 1) 且最多经过 k 个障碍物的最短路径。
 * 
 * 此外，我们还可以对搜索空间进行优化。注意到题目中 k 的上限为 m * n，
 * 但考虑一条从 (0, 0) 向下走到 (m - 1, 0) 再向右走到 (m - 1, n - 1) 的路径，
 * 它经过了 m + n - 1 个位置，其中起点 (0, 0) 和终点 (m - 1, n - 1)
 * 没有障碍物，那么这条路径上最多只会有 m + n - 3 个障碍物。
 * 因此我们可以将 k 的值设置为 m + n - 3 与其本身的较小值 min(k, m + n - 3)，
 * 将广度优先搜索的时间复杂度从 O(MNK)O(MNK) 降低至 O(MN * \min(M + N,
 * K))O(MN∗min(M+N,K))。
 * 
 * 时间复杂度：O(MN * \min(M + N, K))O(MN∗min(M+N,K))。
 * 空间复杂度：O(MN * \min(M + N, K))O(MN∗min(M+N,K))。
 */

class Solution {
    int[] dx = new int[] { 1, 0, -1, 0 };
    int[] dy = new int[] { 0, 1, 0, -1 };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1)
            return 0;

        k = Math.min(k, m + n - 3);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(code(0, 0, k));
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(code(0, 0, k));

        int step = 0;
        while (!q.isEmpty()) {
            step += 1;
            int cnt = q.size();
            while (cnt > 0) {
                cnt -= 1;
                int x, y, rest;
                int[] t = decode(q.poll());
                x = t[0];
                y = t[1];
                rest = t[2];
                for (k = 0; k < 4; k += 1) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                        if (grid[nx][ny] == 0 && !visited.contains(code(nx, ny, rest))) {
                            if (nx == m - 1 && ny == n - 1)
                                return step;
                            q.offer(code(nx, ny, rest));
                            visited.add(code(nx, ny, rest));
                        } else if (grid[nx][ny] == 1 && rest > 0 && !visited.contains(code(nx, ny, rest - 1))) {
                            q.offer(code(nx, ny, rest - 1));
                            visited.add(code(nx, ny, rest - 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int code(int x, int y, int rest) {
        return (rest + y * 10000 + x * 1000000);
    }

    public int[] decode(int c) {
        int rest = c % 10000;
        c /= 10000;
        int y = c % 100;
        c /= 100;
        int x = c;
        return new int[] { x, y, rest };
    }
}

/**
 * 使用DFS實作
 * 
 * 题目意思是若可以任意消除k个障碍物1，找到从网格左上角走到右下角的最短路径步数，找不到返回-1.
 * 
 * 解题思路
 * 运用深度优先搜索：
 * 
 * 每次只能走0点，走过的点可以赋值-1记录，防止循环走重复的点，回溯后要返回原值。
 * 并添加记录，从左上角到右下角经过的1不能超过k个。
 * 每次走到右下角，更新路径的最小值
 * 复杂度分析
 * 时间复杂度：O(4^{nm})
 * 每个点都可能访问，每个点都有四个方向可以选择，但由于k的限制，中间会有一些剪枝操作。
 * 
 * 空间复杂度：O(nm)
 * 只有网格数组grid。
 */
class Solution_3 {
    /**
     * @param grid: a list of list
     * @param k:    an integer
     * @return: Return the minimum number of steps to walk
     */
    public int n, m, mmin;
    public int[] x_dir = new int[] { 1, 0, -1, 0 };
    public int[] y_dir = new int[] { 0, 1, 0, -1 };

    Boolean isValid(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    void dfs(int[][] grid, int x, int y, int k, int count) {
        if (!isValid(x, y) || grid[x][y] == -1) {
            return;
        }

        if ((k == 0 && grid[x][y] == 1) || mmin == m + n - 2) {
            return;
        }

        if (x == m - 1 && y == n - 1) {
            if (count < mmin)
                mmin = count;
            return;
        }

        if (grid[x][y] == 1)
            k--;

        int temp = grid[x][y];
        grid[x][y] = -1;
        for (int d = 0; d < 4; d++) {
            int tempx = x_dir[d] + x;
            int tempy = y_dir[d] + y;
            dfs(grid, tempx, tempy, k, count + 1);
        }
        grid[x][y] = temp;
    }

    public int shortestPath(int[][] grid, int k) {
        // write your code here
        int count = 0;
        mmin = 0x3f3f3f3f;
        m = grid.length;
        n = grid[0].length;

        dfs(grid, 0, 0, k, count);

        if (mmin == 0x3f3f3f3f) {
            return -1;
        } else {
            return mmin;
        }
    }
}

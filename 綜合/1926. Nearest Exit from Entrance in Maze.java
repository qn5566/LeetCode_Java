package 綜合;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 你被給定一個 m × n 矩陣迷宮 maze（索引值從 0 開始）有著空格子（以 '.' 表示）以及牆壁（以 '+' 表示）。你同時也被給定迷宮的入口
 * entrance ，其中 entrance = [entrancerow, entrancecol] 代表著你一開始站的格子之列與行。
 * 
 * 在一步之中，你可以往上下左右移動一格。你不得走入有著牆壁的格子，且你也不能走到迷宮之外。你的目標是找到離入口最近的出口。一個出口被定義為位於迷宮邊緣的空格子。而入口不能算作為一個出口。
 * 
 * 回傳從入口走到最近的出口的最短路徑之所需步數，或是 -1 如果此種路徑不存在。
 * 
 * 限制：
 * maze.length == m
 * maze[i].length == n
 * 1 ≦ m 、 n ≦ 100
 * maze[i][j] 只會是 '.' 或 '+'。
 * entrance.length == 2
 * 0 ≦ entrancerow < m
 * 0 ≦ entrancecol < n
 * 入口保證是一個空格子。
 * 
 * ex1:
 * 輸入： maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance
 * = [1,2]
 * 輸出： 1
 * 解釋： 迷宮中有三個出口分別位於 [1,0] 、 [0,2] 和 [2,3]。
 * 最初，你位於入口格子 [1,2]。
 * - 你可以藉由往左 2 步抵達 [1,0]。
 * - 你可以藉由往上 1 步抵達 [0,2]。
 * 無法從入口抵達 [2,3]。
 * 因此，最近的出口為 [0,2]，其為 1 步遠。
 * 
 * ex2:
 * 輸入： maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * 輸出： 2
 * 解釋： 迷宮中有一個出口位於 [1,2]。
 * [1,0] 不算作一個出口，因為其為入口格子。
 * 最初，你位於入口格子 [0,2]。
 * - 你可以藉由往右 2 步抵達 [0,2]。
 * 因此，最近的出口為 [0,2]，其為 2 步遠。
 * 
 * ex3:
 * 輸入： maze = [[".","+"]], entrance = [0,0]
 * 輸出： -1
 * 解釋： 此迷宮中不存在出口。
 * 
 * 解題思維：
 * 就是單純的走迷宮問題，如這題的方式利用廣度優先搜尋（Breadth First
 * Search，BFS）來找每多走一步可以到的位置。接著檢查這些可以抵達的位置是不是位於迷宮的邊緣且該位置不是入口。如果是就直接回傳目前所花的步數。
 * 
 * 如果所有可以抵達的位置都掃過之後都沒有找到出口，則回傳 -1。
 * 
 * poll：将首个元素从队列中弹出，如果队列是空的，就返回null
 * peek：查看首个元素，不会移除首个元素，如果队列是空的就返回null
 */
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        final int m = maze.length;
        final int n = maze[0].length;
        final int[] dirs = { 0, 1, 0, -1, 0 };
        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>(Arrays.asList(new int[] { entrance[0], entrance[1] }));
        boolean[][] seen = new boolean[m][n];
        seen[entrance[0]][entrance[1]] = true;

        while (!q.isEmpty()) {
            ++ans;
            for (int sz = q.size(); sz > 0; --sz) {
                final int i = q.peek()[0];
                final int j = q.poll()[1];
                for (int k = 0; k < 4; ++k) {
                    final int x = i + dirs[k];
                    final int y = j + dirs[k + 1];
                    if (x < 0 || x == m || y < 0 || y == n)
                        continue;
                    if (seen[x][y] || maze[x][y] == '+')
                        continue;
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1)
                        return ans;
                    q.offer(new int[] { x, y });
                    seen[x][y] = true;
                }
            }
        }

        return -1;
    }
}

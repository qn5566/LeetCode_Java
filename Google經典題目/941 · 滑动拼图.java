package Google經典題目;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 描述
 * 在一块大小为 2x3 的板上，有 5 块瓦片，分别用整数 1 到 5 表示，还有一块空地用 0 表示。
 * 一次移动表示 0 与其相邻的四个方向之一的数字交换位置。
 * 当且仅当 这块板 上的瓦片摆放状态为 [[1,2,3],[4,5,0]] 时，才能说这块板存在的问题被解决了。
 * 给定一个拼图板，返回所需的最少移动次数，以解决该板的状态。如果无法解决板的状态，则返回-1。
 * 
 * 思路与算法
 * 
 * 我们可以使用广度优先搜索，找出从初始状态 \textit{board}board 到目标状态
 * [[1,2,3],[4,5,0]][[1,2,3],[4,5,0]] 的最小交换次数。
 * 具体地，我们在一开始将 (\textit{board}, 0)(board,0) 加入队列，并使用该队列进行广度优先搜索。在搜索的过程中，
 * 设当前搜索到的状态为 \textit{status}status，操作的次数为 \textit{step}step，我们可以枚举
 * \textit{status}status
 * 通过一次操作得到的状态。设其中的某个状态为 \textit{next\_status}next_status，如果其没有被搜索过，
 * 我们就将 (\textit{next\_status}, \textit{step} + 1)(next_status,step+1) 加入队列。
 * 如果搜索到了 \textit{target}target，我们就返回其对应的操作次数。
 * 在搜索的过程中，我们需要一个哈希表存储所有搜索到的状态，避免重复搜索。
 * 如果搜索完成后，我们仍没有搜索到 [[1,2,3],[4,5,0]][[1,2,3],[4,5,0]]，说明我们无法解开谜板，返回 -1−1。
 */
class Solution {
    /**
     * @param board: the given board
     * @return: the least number of moves required so that the state of the board is
     *          solved
     */
    int[][] neighbors = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

    public int slidingPuzzle(int[][] board) {
        // write your code here
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(initial);
        Set<String> seen = new HashSet<String>();
        seen.add(initial);

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus)) {
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    // 枚举 status 通过一次交换操作得到的状态
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        int x = status.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}

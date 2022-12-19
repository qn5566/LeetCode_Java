package 綜合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
 * Output: 3
 * Explanation: We translate img1 to right by 1 unit and down by 1 unit.
 * The number of positions that have a 1 in both images is 3 (shown in red).
 * 
 * Input: img1 = [[1]], img2 = [[1]]
 * Output: 1
 * 
 * Input: img1 = [[0]], img2 = [[0]]
 * Output: 0
 * 
 * 哈希表
 * 记录下每个 1 的位置, 因为 n 不超过 30, 可以转化为 1 维坐标记录
 * 然后将两个坐标的偏移量记录在哈希表中
 * 返回最大的偏移量的数量
 * 时间复杂度为 O(n ^ 4), 空间复杂度为 O(n ^ 2)
 *
 */
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<Integer> grid1 = new ArrayList<>(), grid2 = new ArrayList<>();
        int n = img1.length, result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1)
                    grid1.add(i * 100 + j);
                if (img2[i][j] == 1)
                    grid2.add(i * 100 + j);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : grid1)
            for (int j : grid2)
                map.put(i - j, map.getOrDefault(i - j, 0) + 1);
        for (int v : map.values())
            result = Math.max(result, v);
        return result;
    }
}

package 綜合;

import java.util.ArrayList;
import java.util.List;

/**
 * 从起点到目标点到所有路径
 * 
 * ex:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * 
 * ex:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        dfs(0, graph.length - 1, graph, new ArrayList<>(), res, visited);
        return res;
    }

    // 從cur出發，path代表走到cur時路徑上的所有節點
    private void dfs(int cur, int dest, int[][] graph, List<Integer> path, List<List<Integer>> res, boolean[] visited) {
        // 標記當前頂點爲已訪問，並把當前頂點加入path
        visited[cur] = true;
        path.add(cur);
        // 如果發現了已經到達了終點，則將路徑加入最終結果，然後直接返回；
        // 返回之前要恢復現場
        if (cur == dest) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            visited[cur] = false;
            return;
        }

        for (int next : graph[cur]) {
            // 判斷是否有訪問過
            if (!visited[next]) {
                dfs(next, dest, graph, path, res, visited);
            }
        }

        // 返回之前要恢復現場
        path.remove(path.size() - 1);
        visited[cur] = false;
    }
}
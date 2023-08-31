package BinaryTree二元樹;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ex1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices
 * have an apple. One optimal path to collect all apples is shown by the green
 * arrows.
 * 
 * ex2:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices
 * have an apple. One optimal path to collect all apples is shown by the green
 * arrows.
 */
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> adjacency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjacency.put(i, new HashSet<>());
        }
        int e = edges.length;
        for (int i = 0; i < e; i++) {
            // undirected, 2 directional edges.
            adjacency.get(edges[i][0]).add(edges[i][1]);
            adjacency.get(edges[i][1]).add(edges[i][0]);
        }
        int res = visit(0, visited, adjacency, hasApple);
        if (res == 0) {
            return res;
        }
        return res - 2;
    }

    private int visit(
            int node,
            Set<Integer> visited,
            Map<Integer, Set<Integer>> adjacency,
            List<Boolean> hasApple) {
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);
        int res = 0;
        for (int neighbor : adjacency.get(node)) {
            res += visit(neighbor, visited, adjacency, hasApple);
        }
        if (res != 0 || hasApple.get(node)) {
            res += 2;
        }
        return res;
    }
}

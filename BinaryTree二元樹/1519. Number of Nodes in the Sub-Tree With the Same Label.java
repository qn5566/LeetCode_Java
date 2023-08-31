package BinaryTree二元樹;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels =
 * "abaedcd"
 * Output: [2,1,1,1,1,1,1]
 * Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a'
 * as well, thus the answer is 2. Notice that any node is part of its sub-tree.
 * Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as
 * nodes 4 and 5 have different labels than node 1, the answer is just 1 (the
 * node itself).
 * 
 * Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
 * Output: [4,2,1,1]
 * Explanation: The sub-tree of node 2 contains only node 2, so the answer is 1.
 * The sub-tree of node 3 contains only node 3, so the answer is 1.
 * The sub-tree of node 1 contains nodes 1 and 2, both have label 'b', thus the
 * answer is 2.
 * The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus
 * the answer is 4.
 * 
 * Input: n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
 * Output: [3,2,1,1,1]
 */
class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(graph, 0, -1, labels, ans);

        return ans;
    }

    private int[] dfs(List<Integer>[] graph, int u, int parent, final String labels, int[] ans) {
        int[] count = new int[26]; // Count of letters down from this u

        for (final int v : graph[u]) {
            if (v == parent)
                continue;
            int[] childCount = dfs(graph, v, u, labels, ans);
            for (int i = 0; i < 26; ++i)
                count[i] += childCount[i];
        }

        ans[u] = ++count[labels.charAt(u) - 'a']; // The u itself
        return count;
    }
}
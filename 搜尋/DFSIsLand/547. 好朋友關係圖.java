package 搜尋.DFSIsLand;

/**
 * 题目描述：好友关系可以看成是一个无向图，例如第 0 个人与第 1 个人是好友，那么 M[0][1] 和 M[1][0] 的值都为 1。
 * 
 * 
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 
 * Output: 2
 * 
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * 
 * Explanation:The 0th and 1st students are direct friends, so they are in a
 * friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * 
 * 
 * 時間複雜度 O(n^2)
 * 空間O(n)
 */
class Solution {
    private int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }
}

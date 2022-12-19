package 搜尋.DFSIsLand;

/**
 * 題目說四邊被X圍的O可以換成X
 * 所以先掃四邊，並且用DFS把有搜到的O繼續看有沒有連接再一起
 * 把他們替換成'T'
 * 
 * 先把周圍的格子都先掃過 也就是四邊
 * 最後中間還有O的就可以換成X了
 * 
 * DFS
 */
class Solution {
    private int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private int m, n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;

        // 掃橫
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // 掃列
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        // 最後把沒被掃到的O換成X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        // 有掃到變成T做記號
        board[r][c] = 'T';
        for (int[] d : direction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}

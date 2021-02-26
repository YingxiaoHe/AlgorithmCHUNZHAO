/**
 * 被围绕的区域：https://leetcode-cn.com/problems/surrounded-regions/
 */
public class Solve {

    /**
     * DFS
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     */
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //由题意可知，只有当O在边缘时，才不会被X包围，所以从边缘的O开始遍历改为B
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        //留下的O都是被X包围的，B都是需要保留的O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == 'X' || board[i][j] == 'B') {
            return;
        }
        board[i][j] = 'B';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}

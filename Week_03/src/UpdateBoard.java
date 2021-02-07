/**
 * 扫雷游戏：https://leetcode-cn.com/problems/minesweeper/
 */
public class UpdateBoard {

    private int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    private int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(n^2)
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        int cnt = 0;
        //计算周围地雷数
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            //判断是否在棋盘外
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            board[i][j] = (char) (cnt + '0');
            return;
        }

        //若空地没有雷，则向外搜索
        board[i][j] = 'B';
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                continue;
            }
            dfs(board, x, y);
        }
    }
}

/**
 * N皇后 II：https://leetcode-cn.com/problems/n-queens-ii/
 */
public class TotalNQueens {

    private int num = 0;

    /**
     * 回溯，修改自N皇后I的方法
     */
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for (char[] ch : chess) {
            for (int i = 0; i < n; i++) {
                ch[i] = '.';
            }
        }
        dfs(chess, 0);
        return num;
    }

    private void dfs(char[][] chess, int row) {
        if (row == chess.length) {
            num++;
            return;
        }
        for (int col = 0; col < chess[row].length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfs(chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后
        for (char[] chars : chess) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        //判断左上角有没有皇后
        for (int x = row - 1, y = col - 1; x >= 0 && y >= 0; x--, y--) {
            if (chess[x][y] == 'Q') {
                return false;
            }
        }
        //判断右上角有没有皇后
        for (int x = row - 1, y = col + 1; x >= 0 && y < chess[x].length; x--, y++) {
            if (chess[x][y] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 位运算
     * 时间复杂度：O(n!)
     * 空间复杂度：O(n)
     */
    public int totalNQueens2(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    private int solve(int n, int row, int col, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(col | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                count += solve(n, row + 1, col | position,
                        (diagonals1 | position) << 1, (diagonals2 | position) >> 1);

            }
            return count;
        }
    }

    /**
     * 位运算
     * 时间复杂度：O(n!)
     * 空间复杂度：O(1)
     */
    private int size;
    private int count;

    public int totalNQueens3(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve2(0, 0, 0);
        return count;
    }

    private void solve2(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve2(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后：https://leetcode-cn.com/problems/n-queens/
 */
public class SolveNQueens {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> list = new ArrayList<>();
        dfs(chess, list, 0);
        return list;
    }

    private void dfs(char[][] chess, List<List<String>> list, int row) {
        if (row == chess.length) {
            list.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess[row].length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfs(chess, list, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][col] == 'Q') {
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
        for (int x = row - 1, y = col + 1; x >= 0 && y < chess[row].length; x--, y++) {
            if (chess[x][y] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (char[] chars : chess) {
            path.add(new String(chars));
        }
        return path;
    }
}

/**
 * 不同路径 III：https://leetcode-cn.com/problems/unique-paths-iii/
 */
public class UniquePathsIII {

    /**
     * 深度优先遍历
     * 时间复杂度：O()
     * 空间复杂度：O()
     */
    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int stepNum = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    continue;
                }
                if (grid[i][j] == 0) {
                    stepNum++;
                }
            }
        }
        return dfs(startX, startY, stepNum, grid);
    }

    private int dfs(int x, int y, int stepSur, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return stepSur == 0 ? 1 : 0;
        }
        grid[x][y] = -1;
        int res = 0;
        res += dfs(x - 1, y, stepSur - 1, grid);
        res += dfs(x + 1, y, stepSur - 1, grid);
        res += dfs(x, y - 1, stepSur - 1, grid);
        res += dfs(x, y + 1, stepSur - 1, grid);
        grid[x][y] = 0;
        return res;
    }
}

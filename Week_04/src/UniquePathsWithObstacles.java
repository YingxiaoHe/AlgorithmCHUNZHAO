/**
 * 不同路径 II：https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacles {

    /**
     * 动态规划
     * 因每次遍历时需要对i-1及j-1的元素相加，那么使用一维数组（数组本身继承了上一层的数值)即可对i-1和i相加
     * 当遇到障碍时，说明上一层的路走不通了，所以赋值为0
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0 && obstacleGrid[i][j] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}

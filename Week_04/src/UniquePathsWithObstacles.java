/**
 * 不同路径 II：https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacles {

    /**
     * 动态规划
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && ints[j] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}

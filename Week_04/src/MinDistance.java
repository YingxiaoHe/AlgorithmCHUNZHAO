/**
 * 编辑距离：https://leetcode-cn.com/problems/edit-distance/
 */
public class MinDistance {

    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                //初始化第一行
                if (i == 0) {
                    dp[0][j] = j;
                    continue;
                }
                //初始化第一列
                if (j == 0) {
                    dp[i][0] = i;
                    continue;
                }
                //计算需要的最小操作数
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}

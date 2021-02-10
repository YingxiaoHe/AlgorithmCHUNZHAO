import java.util.Arrays;

/**
 * 不同路径：https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    /**
     * 动态规划
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 组合数学
     * 时间复杂度：O(m)
     * 空间复杂度：O(1)
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}

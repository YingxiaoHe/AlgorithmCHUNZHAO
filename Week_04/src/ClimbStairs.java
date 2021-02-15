/**
 * 爬楼梯：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    /**
     * 数学规律
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double filN = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (filN / sqrt5);
    }

    /**
     * 递归
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(2^n)
     * leetcode会超时
     */
    public int climbStairs3(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

    /**
     * 数学规律
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

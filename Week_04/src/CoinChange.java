/**
 * 零钱兑换：https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    int res = Integer.MAX_VALUE;

    /**
     * 递归
     * 超时
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        findWay(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int coin : coins) {
            findWay(coins, amount - coin, ++count);
        }
    }

    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && memo[i - coins[j]] < min) {
                    min = memo[i - coins[j]] + 1;
                }
            }
            memo[i] = min;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}

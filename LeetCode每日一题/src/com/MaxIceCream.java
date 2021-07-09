package com;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量：https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 */
public class MaxIceCream {

    /**
     * 贪心算法
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     */
    public int maxIceCream(int[] costs, int coins) {
        int maxCount = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (coins > cost) {
                coins -= cost;
                maxCount++;
            }
        }
        return maxCount;
    }
}

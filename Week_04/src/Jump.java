/**
 * 跳跃游戏 II：https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump {

    /**
     * 贪心算法
     * 遍历数组，记录遍历过的能跳跃到的最远坐标，
     * 当遍历到end时算是计算完了最远的一步，
     * 更新end为这中间中能跨越到的最大值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
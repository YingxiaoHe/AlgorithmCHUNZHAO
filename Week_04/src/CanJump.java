/**
 * 跳跃游戏：https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {

    /**
     * 贪心算法
     * 记录每次跳跃时能跳到的最远的坐标k，当k < i时，说明已经跳不过去了
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}

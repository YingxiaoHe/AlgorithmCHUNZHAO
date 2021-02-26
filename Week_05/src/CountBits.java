/**
 * 比特位计数：https://leetcode-cn.com/problems/counting-bits
 */
public class CountBits {

    /**
     * 最后设置位
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    /**
     * 最低有效位
     * 因i与i >> 1的区别只有最后一位数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

}

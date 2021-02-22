/**
 * 2的幂：https://leetcode-cn.com/problems/power-of-two/
 */
public class IsPowerOfTwo {

    /**
     * 位运算
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

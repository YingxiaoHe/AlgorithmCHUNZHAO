/**
 * 位1的个数：https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class HammingWeight {

    /**
     * 位移
     * 时间复杂度：O(1) 因为入参是个int，最高32位，所以是O(1)
     * 空间复杂度：O(1)
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}

import java.util.Arrays;

/**
 * 多数元素：https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(n)
     */
    public int majorityElement(int[] nums) {
        //因排序后，出现次数大于n/2的数无论在哪个位置，数组的length/2的位置必是这个数字
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

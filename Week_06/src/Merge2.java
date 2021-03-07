import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间：https://leetcode-cn.com/problems/merge-intervals/
 */
public class Merge2 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[][] merge(int[][] intervals) {
        //排序区间的起始位置
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            //如果是第一个 或 当前区间的起始位置 > 前一个区间的终止位置
            if (index == -1 || interval[0] > result[index][1]) {
                //不用合并
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}

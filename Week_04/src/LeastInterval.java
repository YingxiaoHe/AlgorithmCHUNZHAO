import java.util.Arrays;

/**
 * 任务调度器：https://leetcode-cn.com/problems/task-scheduler/
 */
public class LeastInterval {

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 由题意可理解为求最大任务数量N-1 * 冷却时间n+1 + 与最大数量任务个数相同的任务数
     */
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        //统计任务出现的次数
        int[] array = new int[26];
        for (char ch : tasks) {
            array[ch - 'A']++;
        }
        //排序后，最后一个数即出现的任务次数最多的数量
        Arrays.sort(array);
        int max =  array[25];
        int cnt = 1;
        //求出与max数量想等的任务有多少个
        for (int i = 0; i < array.length - 1; i++) {
            if (max == array[i]) {
                cnt++;
            }
        }
        return Math.max(len, cnt + (max - 1) * (n + 1));
    }
}

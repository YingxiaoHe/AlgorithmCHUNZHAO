import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 青蛙过河：https://leetcode-cn.com/problems/frog-jump/
 */
public class CanCross {

    /**
     * 动态规划
     * 时间复杂度：O(n^2) 因第三层循环只循环三次，所以是n^2
     * 空间复杂度：O(n^2)
     */
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}

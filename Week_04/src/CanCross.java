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
        //初始化
        //key：石头
        //value：跳到该石头时的跳跃距离
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int stone : stones) {
            //如果该石头可以跳上去，则遍历每个跳上去时的情况
            for (int k : map.get(stone)) {
                //遍历三种可能性，判断是否有能跳上去的石头，如果有则保存跳跃距离
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}

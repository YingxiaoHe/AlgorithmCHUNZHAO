import java.util.*;

public class TopKFrequent {


    /**
     * 前K个高频元素：https://leetcode-cn.com/problems/top-k-frequent-elements/
     * 时间复杂度：O(nlogk)
     * 空间复杂度：O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        //先将每个元素的频率统计出来
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        //利用最小堆，保存频率最大的k个元素
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        map.forEach((key, value) -> {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (value > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        });

        //返回堆中值即频率最大的元素值
        return priorityQueue.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] ints = new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3};
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(ints, 2)));
    }
}

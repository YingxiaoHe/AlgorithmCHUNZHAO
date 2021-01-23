import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TowSum {

    /**
     * 暴力解法
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * hash解法
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                index[0] = map.get(target - nums[i]);
                index[1] = i;
            }
            map.put(nums[i], i);
        }
        return index;
    }

    public static void main(String[] args) {
        TowSum towSum = new TowSum();
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(towSum.twoSum(nums, 9)));
        System.out.println(Arrays.toString(towSum.twoSum2(nums, 9)));
    }
}
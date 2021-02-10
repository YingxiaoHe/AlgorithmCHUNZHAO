import java.util.ArrayList;
import java.util.List;

/**
 * 子集：https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, 0, result, tmp);
        return result;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> result, List<Integer> tmp) {
        result.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            dfs(nums, j + 1, result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}

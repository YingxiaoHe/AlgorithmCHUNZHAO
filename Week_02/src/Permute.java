import java.util.ArrayList;
import java.util.List;

/**
 * 全排列：https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    /**
     * 时间复杂度：O(n*n!)
     * 空间复杂度：O(n*n!)
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == len) {
            //找到一个结果，保存并返回
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                //递归遍历下一位数字
                dfs(nums, len, depth + 1, path, used, result);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}

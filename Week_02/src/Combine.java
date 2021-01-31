import java.util.*;

/**
 * 组合：https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, result);
        return result;
    }

    /**
     * 时间复杂度：O(n!)
     * 空间复杂度：O(n)
     */
    private void dfs(int n, int k, int index, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n - k + path.size() + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, result);
            path.removeLast();
        }
    }
}

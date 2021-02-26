import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成：https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    /**
     * 深度优先便利
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs("", 0, 0, n, result);
        return result;
    }

    private void dfs(String str, int left, int right, int n, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(str + "(", left + 1, right, n, result);
        }
        if (right < n) {
            dfs(str + ")", left, right + 1, n, result);
        }
    }

}

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号：https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 感觉这个解法不如下面两个解法易懂
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int longestValidParentheses2(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        //此处入栈-1，为方便计算长度
        //如前两个为()，则长度为：1 - （-1） = 2
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 使用left、right两个常数来记录左右括号的数量
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int longestValidParentheses3(String s) {
        int left = 0;
        int right = 0;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, right * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }
        //因正循环一遍后，当左括号>右括号时，求不出最大值。
        //所以再反向循环一遍，求两次循环的最大值。
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}

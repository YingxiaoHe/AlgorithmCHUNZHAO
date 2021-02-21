/**
 * 回文子串：https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class CountSubstrings {

    /**
     * 中心扩展
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int countSubstrings(String s) {
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}

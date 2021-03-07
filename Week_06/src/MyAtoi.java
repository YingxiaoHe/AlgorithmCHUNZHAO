/**
 * 8. 字符串转换整数 (atoi)：https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int myAtoi(String s) {
        String s1 = s.trim();
        if (s1.length() == 0) {
            return 0;
        }
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            //判断有正负号的时候
            if (i == 0) {
                if (ch == '+') {
                    continue;
                } else if (ch == '-') {
                    sign = -1;
                    continue;
                }
            }
            //当遇到非数字时，结束循环
            if (ch > '9' || ch < '0') {
                break;
            }
            int cur = ch - '0';
            //排除边界情况
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < cur) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && Integer.MIN_VALUE % 10 > -cur) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * cur;
        }
        return res;
    }
}

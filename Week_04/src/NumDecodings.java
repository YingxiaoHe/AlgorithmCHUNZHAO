/**
 * 解码方法：https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {

    /**
     * 时间复杂的：O(n)
     * 空间复杂度：O(1)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] ch = s.toCharArray();
        if (ch[0] == '0') {
            return 0;
        }
        int cur = 1;
        //记录截至到上一位数时的数量
        int pre = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = cur;
            if (ch[i] == '0') {
                if (ch[i - 1] == '1' || ch[i - 1] == '2') {
                    cur = pre;
                } else {
                    //非法情况，返回0
                    return 0;
                }
            } else if (ch[i - 1] == '1' || ch[i - 1] == '2' && ch[i] >= '1' && ch[i] <= '6') {
                cur = cur + pre;
            }
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings("12"));
        System.out.println(numDecodings.numDecodings("10"));
        System.out.println(numDecodings.numDecodings("224"));
    }
}

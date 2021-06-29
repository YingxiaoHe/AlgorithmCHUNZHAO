import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码：https://leetcode-cn.com/problems/decode-string/
 */
public class DecodeString {

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int multi = 0;
        Deque<Integer> stackMulti = new LinkedList<>();
        Deque<String> stackRes = new LinkedList<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '[') {
                stackMulti.push(multi);
                stackRes.push(result.toString());
                multi = 0;
                result = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackMulti.pop();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(result);
                }
                result = new StringBuilder(stackRes.pop() + tmp);
            } else if (ch >= '0' && ch <= '9') {
                multi = multi * 10 + Integer.parseInt(ch + "");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}

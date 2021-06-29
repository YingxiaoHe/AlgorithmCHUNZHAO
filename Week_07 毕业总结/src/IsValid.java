import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValid {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        stack.push('?');
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || map.get(stack.peek()) != ch) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}

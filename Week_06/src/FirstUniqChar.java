import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
